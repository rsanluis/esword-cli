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
     * By adding 62 weeks to 8/24/2022, we get 11/01/2023
     * The seven weeks and threescore and two weeks in Daniel 9:25
     * seven weeks                         =  7 weeks 
     * threescore and two weeks = 3*20 + 2 = 62 weeks
     *                                       69 weeks total
     * Add 7 weeks to 7/6/2022
     *   7/6/2022 + 7 weeks                = 8/24/2022
     * Add 62 weeks to 8/24/2022
     *   8/24/2022 + 62 weeks              = 11/01/2023
     * 7/6/2022 to 11/01/2023              = 69 weeks total
     */
    @Test
    public void testAdd62WeeksTo_8_24_2022() {
        LocalDate localDate = LocalDate.of(2022,8,24).plusWeeks(62);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==11);
        assertTrue(day==1);
        assertTrue(year==2023);
    }

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
