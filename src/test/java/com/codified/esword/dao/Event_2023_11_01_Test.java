package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2023_11_01_Test {
    
    /*
     * Deuteronomy 18:22  When a prophet speaketh in the name of the LORD, if the thing 
     * follow not, nor come to pass, that is the thing which the LORD hath not spoken, 
     * but the prophet hath spoken it presumptuously: thou shalt not be afraid of him. 
     */

    @Test
    public void testDaysBetween9_11_2001_and_11_01_2023() {
        // Calculate the number of days between 9/11/2001 and 11/23/2023
        long daysBetween = DAYS.between(
            LocalDate.of(2001,9,11),
            LocalDate.of(2023,11,1)
        );
        assertTrue(daysBetween==8086);
        // https://www.timeanddate.com/date/durationresult.html?d1=11&m1=9&y1=2001&d2=1&m2=11&y2=2023
        //
        // H8086
        // שְׁמַע
        // shema‛
        // shem-ah'
        // (Chaldee); corresponding to H8085: - hear, obey.
        // Total KJV occurrences: 9
        //
        // If you do a search for the word obey in e-Sword within the KJV+ bible, you will get
        //   66 verse matches and 69 actual matches
        // esword search -c Bible -s obey
        //   verses: 66    matches: 69
    } 
}
