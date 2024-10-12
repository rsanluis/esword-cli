package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2025_05_13_Test {
    //
    // Event 05/13/2025 - May 13th, 2025 - The Day of Mourning
    // Test created on: 10/12/2024
    //
    // 
    @Test
    public void testAdd_315_Days_from_December_6_2023() {
        LocalDate localDate = LocalDate.of(2023,12,23).minusDays(315);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==10);
        assertTrue(day==16);
        assertTrue(year==2024);
    }
}





