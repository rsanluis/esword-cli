package com.codified.esword.util;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
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
     * Convenience overload accepting a full date; only its month and day are used.
     */
    public static String determineMonthAndDay(LocalDate date, Operation operation, int days) {
        return determineMonthAndDay(MonthDay.from(date), operation, days);
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

        for (int year = START_YEAR; year <= END_YEAR; year++) {
            // Skip years where the start date doesn't exist (e.g. Feb 29 in non-leap years)
            if (!startMonthDay.isValidYear(year)) {
                continue;
            }
            LocalDate result = operation.apply(startMonthDay.atYear(year), days);
            hits.merge(MonthDay.from(result), 1, Integer::sum);
        }

        int total = hits.values().stream().mapToInt(Integer::intValue).sum();
        hits.forEach((monthDay, count) -> log.info("\t{} {} {} days -> {}: {} matches ({})",
                startMonthDay.format(OUTPUT_FORMAT), operation.symbol,
                days, monthDay.format(OUTPUT_FORMAT), count, percent(count, total)));

        MonthDay winner = hits.entrySet().stream()
                .max(Map.Entry.<MonthDay, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .map(Map.Entry::getKey)
                .orElseThrow();

        String formatted = winner.format(OUTPUT_FORMAT);
        log.info("Most Occurrences: {} with {} matches ({})", formatted, hits.get(winner),
                percent(hits.get(winner), total));
        return formatted;
    }

    private static String percent(int count, int total) {
        return String.format(Locale.ENGLISH, "%.2f%%", count * 100.0 / total);
    }
}
