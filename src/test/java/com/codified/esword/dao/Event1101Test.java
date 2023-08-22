package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Event1101Test {

    // Event 1101 - 11/01/2023 - Revelation 14:8  And there followed another angel,
    //   saying, Babylon is fallen, is fallen, that great city, because she made all 
    //   nations drink of the wine of the wrath of her fornication. 

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
