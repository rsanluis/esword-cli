package com.codified.esword.util;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class DateUtils {

    // Note: We could have started at year 1 but we are going by percentage and the percentage will
    // likely be the same starting at an earlier year, so we can save time by starting at a later year
    // and at the year 1600 after the Gregorian calendar was adopted by most countries, so we will start at 1600 and 
    // go to 2030 which is the last year we will be using in this app

    private static final int START_YEAR = 1600;
    private static final int END_YEAR = 2030;
    // STRICT so impossible dates like 2/30 are rejected instead of silently adjusted to 2/28
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("M/d/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH);

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
     * Convenience overload accepting a date string such as "10/30/2000".
     *
     * @throws IllegalArgumentException if the date is not in M/d/yyyy format, the month
     *         is not 1-12, the day is not 1-31, or the day does not exist in that month
     *         (e.g. 2/30/2000)
     */
    public static String determineMonthAndDay(String date, Operation operation, int days) {
        return determineMonthAndDay(parseDate(date), operation, days);
    }

    private static LocalDate parseDate(String date) {
        if (date == null || !date.trim().matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            throw new IllegalArgumentException("Invalid date '" + date + "': expected format M/d/yyyy (e.g. 10/30/2000)");
        }
        String[] parts = date.trim().split("/");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month " + month + " in '" + date + "': month must be 1-12");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day " + day + " in '" + date + "': day must be 1-31");
        }
        try {
            return LocalDate.parse(date.trim(), INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date '" + date + "': day " + day
                    + " does not exist in month " + month, e);
        }
    }

    /**
     * Takes the month and day of the given date, applies it to every year from
     * START_YEAR to END_YEAR, adds or subtracts {@code days} days according to
     * {@code operation}, and returns the resulting month/day combination that
     * occurs most often (e.g. "May 13").
     * Ties are broken by the earliest month/day in the calendar.
     */
    public static String determineMonthAndDay(LocalDate date, Operation operation, int days) {
        MonthDay startMonthDay = MonthDay.from(date);
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
        hits.forEach((monthDay, count) ->
                log.info("\t{} {} {} days -> {}: {} matches ({})", startMonthDay.format(OUTPUT_FORMAT), operation.symbol,
                        days, monthDay.format(OUTPUT_FORMAT), count, percent(count, total)));

        MonthDay winner = hits.entrySet().stream()
                .max(Map.Entry.<MonthDay, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder())))
                .map(Map.Entry::getKey)
                .orElseThrow();

        String formatted = winner.format(OUTPUT_FORMAT);
        log.info("Most Occurrences: {} with {} matches ({})", formatted, hits.get(winner), percent(hits.get(winner), total));
        return formatted;
    }

    private static String percent(int count, int total) {
        return String.format(Locale.ENGLISH, "%.2f%%", count * 100.0 / total);
    }
}
