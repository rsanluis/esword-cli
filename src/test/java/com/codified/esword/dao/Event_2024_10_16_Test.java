package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2024_10_16_Test {
    //
    // Event 10/16/2024 - October 16th, 2024 - 315 days after the Start of Tribulation 12/6/2023
    // Test created on: 10/12/2024
    //
    // 2520 / 8 = 315
    //
    // The last week (7 year tribulation period) will consist of 8 parts of 315 days
    //
    // Notice how the 8 parts align with the 8 watchman pattern in the following graph:
    //   https://github.com/rsanluis/esword-cli/blob/41994a60eda52e77d438761dc52a645b0e1b35a5/images/patterns/2520_wheel_within_a_wheel.png
    //
    // Notice how the pattern of my birthday 513 is the reverse of 315, 
    //   just like the pattern of 53 (hebrew gematria of Lamb or "I am he" is 53) is the reverse of 35 (simple gematria of El Deah)
    //
    // Adding the first 315th part or slice to the Start of Tribulation will yield the first date 10/16/2024
    //
    @Test
    public void testAdd_315_Days_from_December_6_2023() {
        LocalDate localDate = LocalDate.of(2023,12,6).plusDays(315);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==10);
        assertTrue(day==16);
        assertTrue(year==2024);
    }
}





