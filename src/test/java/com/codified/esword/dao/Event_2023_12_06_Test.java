package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2023_12_06_Test {
    // 
    // Event 12/06/2023 - December 6th, 2023 - The start of the (1260 * 2) timeline
    // 
    // Dan 9:27  And he shall confirm the covenant with many for one week
    // 
    // November 1st, 2023 - Tragic Day for America
    // 11/01/2023 + 35 days is 12/6/2023 - The Start of Tribulation
   
    // Start week: 12/06/2023
    // Mid   week:  5/19/2027 (12/06/2023 + 1260 days)
    // End   week: 10/30/2030 ( 5/19/2027 + 1260 days)
    @Test
    public void testDaysBetweenNovember_1_2023_and_December_6_2023() {
        // Confirm and validate the start dates for both timelines
        // (1290*2 [God's timeline]) vs. (1260*2 [Man's timeline]) is 60 days apart
        LocalDate localDate = LocalDate.of(2023,10,07).plusDays(60);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==12);
        assertTrue(day==6);
        assertTrue(year==2023);
    }
}
