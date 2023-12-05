package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2022_08_24_Test {
    //
    // Event 08/24/2022 - August 24th, 2022 - Macron's warning of end of abundance and
    // sacrifices ahead.
    //
    // By adding 7 weeks to the 7/6/2022 Georgia Guidestones destruction date,
    // we land on the date: 8/24/2022. 
    // If we search for events on 8/24/2022, we get a press release where French
    // President warns of sacrifices ahead after end of abundance.
    //
    // Macron warns 'sacrifices' ahead after 'end of abundance'
    // https://www.youtube.com/watch?v=IU8p_nuK6Yw
    // https://web.archive.org/web/20220824222755/https://www.france24.com/en/france/20220824-macron-warns-french-of-tough-times-ahead-end-to-energy-price-cap
    // 
    // Genesis 41:29  Behold, there come seven years of great plenty throughout all the land of Egypt: 
    // Genesis 41:30  And there shall arise after them seven years of famine; and all the plenty shall
    //   be forgotten in the land of Egypt; and the famine shall consume the land; 
    // 
    // This is signaling that the close of the 69th week of Daniel is nearby.
    // The prior week of (abundance or plenty) before the week of (famine).
    // 
    // https://raw.githubusercontent.com/rsanluis/esword-cli/main/images/books/2030_second_coming_2023_tribulation.png
    //
    @Test
    public void testDaysBetweenJuly_6_2022_and_Aug_24_2022() {
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
}
