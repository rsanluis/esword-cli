package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event1101Test {

    // Event 1101 - 11/01/2023 - Revelation 14:8  And there followed another angel,
    //   saying, Babylon is fallen, is fallen, that great city, because she made all 
    //   nations drink of the wine of the wrath of her fornication. 

    // Number of days between 7/6/2022 and 11/01/2023 = 483 days
    // 7/6/2022 is the destruction date of the Georgia Guidestones
    /*
     * Daniel 9:25  Know therefore and understand, that from the going forth of the commandment 
     * to restore and to build Jerusalem unto the Messiah the Prince shall be seven weeks, 
     * and threescore and two weeks: the street shall be built again, and the wall, even in 
     * troublous times. 
     * 
     * It is exactly 69 weeks (or 483 days) leading up to the 11/01/2023 date.
     */
    @Test
    public void testDaysBetween7_6_2022_and_11_01_2023() {
        LocalDate localDate = LocalDate.of(2022,07,06).plusWeeks(69);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==11);
        assertTrue(day==1);
        assertTrue(year==2023);

        // 69 weeks is equal to 483 days
        localDate = LocalDate.of(2022,07,06).plusDays(483);
        month = localDate.getMonthValue();
        day = localDate.getDayOfMonth();
        year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==11);
        assertTrue(day==1);
        assertTrue(year==2023);
    }

    /* 
     * Now let's add 7 weeks to the 7/6/2022 Georgia Guidestones destruction date.
     * We get 8/24/2022. 
     * If we search for events on 8/24/2022, we get a press release where French
     * President warns of sacrifices ahead after end of abundance.
     * [Youtube.com]
     * Macron warns 'sacrifices' ahead after 'end of abundance'
     * https://www.youtube.com/watch?v=IU8p_nuK6Yw
     * https://web.archive.org/web/20220824222755/https://www.france24.com/en/france/20220824-macron-warns-french-of-tough-times-ahead-end-to-energy-price-cap
     */
    @Test
    public void testDaysBetween7_6_2022_and_8_24_2022() {
        LocalDate localDate = LocalDate.of(2022,07,06).plusWeeks(7);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==8);
        assertTrue(day==24);
        assertTrue(year==2022);
    }

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
