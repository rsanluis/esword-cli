package com.codified.esword.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class DateUtils {

    // Note: We could have started at year 1 but we are going by percentage and the
    // percentage will
    // likely be the same starting at an earlier year, so we can save time by
    // starting at a later year
    // and at the year 1600 after the Gregorian calendar was adopted by most
    // countries, so we will start at 1600 and
    // go to 2030 which is the last year we will be using in this app

    private static final int START_YEAR = 1600;
    private static final int END_YEAR = 2030;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH);
    private static final DateTimeFormatter OUTPUT_FORMAT_WITH_YEAR = DateTimeFormatter.ofPattern("MMMM d, uuuu",
            Locale.ENGLISH);
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("M/d/uuuu", Locale.ENGLISH)
            .withResolverStyle(ResolverStyle.STRICT);
    private static final String QUICKCHART_URL = "https://quickchart.io/chart?v=4&c=";
    // Pie slice colors by rank: 1st = green, 2nd = blue, 3rd = dark blue
    private static final String[] RANK_COLORS = { "#2E9E44", "#3B82F6", "#1E3A8A" };
    private static final String OTHER_COLOR = "#B0B0B0";

    public enum Operation {
        ADD("+"),
        SUBTRACT("-");

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        LocalDate apply(LocalDate date, int days) {
            return this == ADD ? date.plusDays(days) : date.minusDays(days);
        }
    }

    private DateUtils() {
    }

    /**
     * Adds or subtracts {@code days} days to/from the given date according to
     * {@code operation} and returns the exact resulting date (e.g. "October 30,
     * 2030").
     */
    public static String determineExactMonthDayAndYear(LocalDate date, Operation operation, int days) {
        Objects.requireNonNull(date, "date must not be null");
        Objects.requireNonNull(operation, "operation must not be null");
        String formatted = operation.apply(date, days).format(OUTPUT_FORMAT_WITH_YEAR);
        log.info("{} {} {} days -> {}", date.format(OUTPUT_FORMAT_WITH_YEAR), operation.symbol, days, formatted);
        return formatted;
    }

    /**
     * Parses {@code date} in month/day/year format (e.g. "7/13/2024" or
     * "07/13/2024"), adds or subtracts {@code days} days according to
     * {@code operation}, and returns the exact resulting date (e.g. "October 30,
     * 2030").
     *
     * @throws java.time.format.DateTimeParseException if {@code date} is not a
     *                                                 valid month/day/year date
     */
    public static String determineExactMonthDayAndYear(String date, Operation operation, int days) {
        Objects.requireNonNull(date, "date must not be null");
        return determineExactMonthDayAndYear(LocalDate.parse(date.trim(), INPUT_FORMAT), operation, days);
    }

    /**
     * Takes the given month and day, applies it to every year from
     * START_YEAR to END_YEAR, adds or subtracts {@code days} days according to
     * {@code operation}, and returns the resulting month/day combination that
     * occurs most often (e.g. "May 13").
     * Ties are broken by the earliest month/day in the calendar.
     */
    public static String determineMonthAndDay(MonthDay startMonthDay, Operation operation, int days) {
        Objects.requireNonNull(startMonthDay, "startMonthDay must not be null");
        Objects.requireNonNull(operation, "operation must not be null");
        Map<MonthDay, Integer> hits = new TreeMap<>();
        int total = 0;

        for (int year = START_YEAR; year <= END_YEAR; year++) {
            // Skip years where the start date doesn't exist (e.g. Feb 29 in non-leap years)
            if (!startMonthDay.isValidYear(year)) {
                continue;
            }
            LocalDate result = operation.apply(startMonthDay.atYear(year), days);
            hits.merge(MonthDay.from(result), 1, (a, b) -> a + b);
            total++;
        }

        final int grandTotal = total;
        hits.forEach((monthDay, count) -> log.info("\s\s\s{} {} {} days -> {}: {} matches ({})",
                startMonthDay.format(OUTPUT_FORMAT), operation.symbol,
                days, monthDay.format(OUTPUT_FORMAT), count, percent(count, grandTotal)));

        Map.Entry<MonthDay, Integer> winner = hits.entrySet().stream()
                .max(Map.Entry.<MonthDay, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .orElseThrow();

        String formatted = winner.getKey().format(OUTPUT_FORMAT);
        int winnerCount = winner.getValue();
        log.info("[{}] is the Month/Day result with the most matches: {} matches ({})", formatted, winnerCount,
                percent(winnerCount, grandTotal));
        String pieChartTitle = String.format(Locale.ENGLISH,
                operation == Operation.ADD
                        ? "Adding %d days to %s for years %d to %d"
                        : "Subtracting %d days from %s for years %d to %d",
                days, startMonthDay.format(OUTPUT_FORMAT), START_YEAR, END_YEAR);
        String mainTitle = formatted;
        log.info("Pie chart: {}", buildPieChartUrl(hits, grandTotal, mainTitle, pieChartTitle));
        return formatted;
    }

    /**
     * Builds a QuickChart.io URL (which renders Chart.js configs as images) for a
     * pie chart with one slice per month/day, labeled with the date and its
     * percentage of all matches.
     */
    static String buildPieChartUrl(Map<MonthDay, Integer> hits, int total, String mainTitle, String subTitle) {
        // Rank slices by match count (ties -> earliest date) to assign the top colors
        List<MonthDay> ranked = hits.entrySet().stream()
                .sorted(Map.Entry.<MonthDay, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(entry -> entry.getKey())
                .toList();

        StringJoiner labels = new StringJoiner(",", "[", "]");
        StringJoiner data = new StringJoiner(",", "[", "]");
        StringJoiner colors = new StringJoiner(",", "[", "]");
        StringJoiner matches = new StringJoiner(",", "[", "]");
        hits.forEach((monthDay, count) -> {
            matches.add(String.valueOf(count));
            labels.add("\"" + monthDay.format(OUTPUT_FORMAT) + " (" + percent(count, total) + ")\"");
            data.add(String.format(Locale.ENGLISH, "%.2f", count * 100.0 / total));
            int rank = ranked.indexOf(monthDay);
            colors.add("\"" + (rank < RANK_COLORS.length ? RANK_COLORS[rank] : OTHER_COLOR) + "\"");
        });
        String config = "{\"type\":\"pie\",\"data\":{\"labels\":" + labels
                + ",\"datasets\":[{\"data\":" + data + ",\"backgroundColor\":" + colors
                + ",\"matches\":" + matches + "}]}"
                // QuickChart bundles chartjs-plugin-datalabels; draw date, match count
                // and percent on three lines inside each slice
                // Chart.js 4 (subtitles need 3.4+): titles live under options.plugins
                + ",\"options\":{\"plugins\":{"
                + "\"title\":{\"display\":true,\"text\":\"" + escapeJson(mainTitle) + "\","
                + "\"color\":\"" + RANK_COLORS[0] + "\",\"font\":{\"weight\":\"bold\"}},"
                + "\"subtitle\":{\"display\":true,\"text\":\"" + escapeJson(subTitle) + "\","
                + "\"font\":{\"weight\":\"bold\"}},"
                + "\"datalabels\":{\"color\":\"#FFFFFF\",\"font\":{\"weight\":\"bold\",\"size\":8},"
                + "\"textAlign\":\"center\",\"formatter\":(v,ctx)=>[ctx.chart.data.labels[ctx.dataIndex]"
                + ".replace(/ \\(.*/,''),ctx.dataset.matches[ctx.dataIndex]+' matches',v.toFixed(2)+'%']}}}}";
        return QUICKCHART_URL + URLEncoder.encode(config, StandardCharsets.UTF_8);
    }

    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String percent(int count, int total) {
        return String.format(Locale.ENGLISH, "%.2f%%", count * 100.0 / total);
    }
}
