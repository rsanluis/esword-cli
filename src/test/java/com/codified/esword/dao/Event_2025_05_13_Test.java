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
    // The 11 days starting from the Command to Speak (May 2nd 2025) to the Day of Mourning (May 13th 2025) are the most important period of
    // biblical prophecy during the End Times. 
    //
    // This will test if you're a follower of Christ
    // Revelation 14:4 - Rev 14:4  These are they which were not defiled with women; for they are virgins. 
    //   These are they which follow the Lamb whithersoever he goeth. These were redeemed from among men, being the firstfruits unto God and to the Lamb. 
    //
    // 
    // May 9th 2025 to October 30th 2030 is 2000 days
    //   Jesus will come back in 2 days from this very day.
    //   1 day will become 1000 days instead of 1000 years
    //   One day for a year prophecy no longer applies within the last week of Daniel
    //
    //   How so?
    //   Matthew 24:22 - And except those days should be shortened, there should no flesh be saved: but for the elect's sake those days shall be shortened. 
    //   Mark 13:20 - And except that the Lord had shortened those days, no flesh should be saved: but for the elect's sake, whom he hath chosen, he hath shortened the days.
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





