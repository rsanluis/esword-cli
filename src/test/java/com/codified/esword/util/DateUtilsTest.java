package com.codified.esword.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

import com.codified.esword.util.DateUtils.Operation;

class DateUtilsTest {

    @Test
    void determineMonthAndDay_addFromMonthDay_returnsMay13() {
        assertEquals("May 13", DateUtils.determineMonthAndDay(MonthDay.of(10, 30), Operation.ADD, 3117));
    }

    @Test
    void determineMonthDayAndYear_addFromLocalDate_returnsOctober302030() {
        assertEquals("October 30, 2030",
                DateUtils.determineExactMonthDayAndYear(LocalDate.of(2024, 7, 13), Operation.ADD, 2300));
    }

    @Test
    void determineMonthDayAndYear_subtractFromLocalDate_returnsJuly132024() {
        assertEquals("July 13, 2024",
                DateUtils.determineExactMonthDayAndYear(LocalDate.of(2030, 10, 30), Operation.SUBTRACT, 2300));
    }

    @Test
    void determineExactMonthDayAndYear_addFromString_returnsOctober302030() {
        assertEquals("October 30, 2030",
                DateUtils.determineExactMonthDayAndYear("7/13/2024", Operation.ADD, 2300));
    }

    @Test
    void determineExactMonthDayAndYear_subtractFromString_returnsJuly132024() {
        assertEquals("July 13, 2024",
                DateUtils.determineExactMonthDayAndYear("10/30/2030", Operation.SUBTRACT, 2300));
    }

    @Test
    void determineExactMonthDayAndYear_zeroPaddedString_isAccepted() {
        assertEquals("October 30, 2030",
                DateUtils.determineExactMonthDayAndYear("07/13/2024", Operation.ADD, 2300));
    }

    @Test
    void determineExactMonthDayAndYear_leapDayString_isValid() {
        assertEquals("March 1, 2024",
                DateUtils.determineExactMonthDayAndYear("2/29/2024", Operation.ADD, 1));
    }

    @Test
    void determineExactMonthDayAndYear_invalidLeapDayString_throws() {
        assertThrows(DateTimeParseException.class,
                () -> DateUtils.determineExactMonthDayAndYear("2/29/2023", Operation.ADD, 1));
    }

    @Test
    void determineExactMonthDayAndYear_wrongFormatString_throws() {
        assertThrows(DateTimeParseException.class,
                () -> DateUtils.determineExactMonthDayAndYear("2024-07-13", Operation.ADD, 1));
    }

    @Test
    void determineExactMonthDayAndYear_nullString_throws() {
        assertThrows(NullPointerException.class,
                () -> DateUtils.determineExactMonthDayAndYear((String) null, Operation.ADD, 1));
    }

    @Test
    void determineMonthAndDay_subtractFromMonthDay_returnsOctober30() {
        assertEquals("October 30", DateUtils.determineMonthAndDay(MonthDay.of(5, 13), Operation.SUBTRACT, 3117));
    }

    @Test
    // G5479 - From G5463; cheerfulness, that is, calm delight: - gladness, X
    // greatly, (X be exceeding) joy (-ful, -fully, -fulness, -ous).
    void determineMonthAndDay_subtract5479FromOctober30MonthDay_returnsOctober30() {
        assertEquals("October 30", DateUtils.determineMonthAndDay(MonthDay.of(10, 30), Operation.SUBTRACT, 5479));
    }

    @Test
    void determineMonthAndDay_add5479ToOctober30MonthDay_returnsOctober30() {
        assertEquals("October 30", DateUtils.determineMonthAndDay(MonthDay.of(10, 30), Operation.ADD, 5479));
    }

    @Test
    void determineMonthAndDay_nullMonthDay_throws() {
        assertThrows(NullPointerException.class,
                () -> DateUtils.determineMonthAndDay((MonthDay) null, Operation.ADD, 3117));
    }

    @Test
    void determineMonthAndDay_leapDay_isValid() {
        DateUtils.determineMonthAndDay(MonthDay.of(2, 29), Operation.ADD, 1);
    }
}
