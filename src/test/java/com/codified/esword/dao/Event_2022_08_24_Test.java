package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2022_08_24_Test {
    /* Event 08/24/2022 - August 24th, 2022 - Macron's warning of end of abundance and
     * sacrifices ahead.
     * By adding 7 weeks to the 7/6/2022 Georgia Guidestones destruction date,
     * we land on the date: 8/24/2022. 
     * If we search for events on 8/24/2022, we get a press release where French
     * President warns of sacrifices ahead after end of abundance.
     * [Youtube.com]
     * Macron warns 'sacrifices' ahead after 'end of abundance'
     * https://www.youtube.com/watch?v=IU8p_nuK6Yw
     * https://web.archive.org/web/20220824222755/https://www.france24.com/en/france/20220824-macron-warns-french-of-tough-times-ahead-end-to-energy-price-cap
     * 
     * Gen 41:29  Behold, there come seven years of great plenty throughout all the land of Egypt: 
     * Gen 41:30  And there shall arise after them seven years of famine; and all the plenty shall
     *   be forgotten in the land of Egypt; and the famine shall consume the land; 
     * 
     * This is signaling that the close of the 69th week of Daniel is nearby.
     * The prior week of (abundance or plenty) before the week of (famine).
     * 
     * images/2030_second_coming_2023_tribulation.png
     */
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
}
