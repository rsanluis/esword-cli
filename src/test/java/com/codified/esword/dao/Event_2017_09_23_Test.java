package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2017_09_23_Test {
    // Event 09/23/2017 - September 23rd, 2017 - A Great Wonder in Heaven
    // Revelation 12:1 - And there appeared a great wonder in heaven; a woman
    //   clothed with the sun, and the moon under her feet, and upon her head
    //   a crown of twelve stars.
    //
    // Revelation 12 Sign in 5 Minutes! September 23 2017 Alignment
    // https://www.youtube.com/watch?v=ZSqPiR2EK2s
    // https://github.com/rsanluis/esword-cli/blob/main/images/events/2017_09_23/Event_2017_09_23_Test.png
    // 
    @Test
    public void testDaysBetweenSeptember_23_2017_and_November_1_2023() {
        long daysBetween = DAYS.between(
            LocalDate.of(2017,9,23),
            LocalDate.of(2023,11,1)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==2230);
        // What is the significance of 2230?
        // The Hebrew code points to a flood, overflowing, storm
        //
        // H2230
        // זֶרֶם
        // zerem
        // zeh'-rem
        // From H2229; a gush of water: - flood, overflowing, shower, storm, tempest.
        // Total KJV occurrences: 9
        //
        // https://www.timeanddate.com/date/dateadded.html?d1=23&m1=9&y1=2017&type=add&ay=&am=&aw=&ad=2230&rec=
        // https://github.com/rsanluis/esword-cli/blob/main/images/events/2017_09_23/Adding_2230_Days_to_September_23_2017.png
    }
}
