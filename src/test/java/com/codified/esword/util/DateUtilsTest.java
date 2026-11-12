package com.codified.esword.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codified.esword.util.DateUtils.Operation;

class DateUtilsTest {

    @Test
    void determineMonthAndDay_addFromString_returnsMay13() {
        assertEquals("May 13", DateUtils.determineMonthAndDay("10/30/2030", Operation.ADD, 3117));
    }

    @Test
    void determineMonthAndDay_addFromLocalDate_returnsMay13() {
        assertEquals("May 13", DateUtils.determineMonthAndDay(LocalDate.of(2030, 10, 30), Operation.ADD, 3117));
    }

    @Test
    void determineMonthAndDay_subtractFromString_returnsOctober30() {
        assertEquals("October 30", DateUtils.determineMonthAndDay("5/13/2030", Operation.SUBTRACT, 3117));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0/15/2030", "13/15/2030"})
    void determineMonthAndDay_invalidMonth_throws(String date) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> DateUtils.determineMonthAndDay(date, Operation.ADD, 3117));
        assertTrue(e.getMessage().contains("month must be 1-12"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10/0/2030", "10/32/2030"})
    void determineMonthAndDay_invalidDay_throws(String date) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> DateUtils.determineMonthAndDay(date, Operation.ADD, 3117));
        assertTrue(e.getMessage().contains("day must be 1-31"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2/30/2030", "4/31/2030"})
    void determineMonthAndDay_dayNotInMonth_throws(String date) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> DateUtils.determineMonthAndDay(date, Operation.ADD, 3117));
        assertTrue(e.getMessage().contains("does not exist in month"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abc", "10-30-2030", "10/30/30"})
    void determineMonthAndDay_badFormat_throws(String date) {
        assertThrows(IllegalArgumentException.class,
                () -> DateUtils.determineMonthAndDay(date, Operation.ADD, 3117));
    }

    @Test
    void determineMonthAndDay_leapDay_isValid() {
        DateUtils.determineMonthAndDay("2/29/2000", Operation.ADD, 1);
    }
}
