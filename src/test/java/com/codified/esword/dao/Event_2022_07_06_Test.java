package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2022_07_06_Test {
   /* Event 07/06/2022 - July 6th, 2022 - The destruction date of the Georgia Guidestones
    * Daniel 9:25  Know therefore and understand, that from the going forth of the commandment 
    * to restore and to build Jerusalem unto the Messiah the Prince shall be seven weeks, 
    * and threescore and two weeks: the street shall be built again, and the wall, even in 
    * troublous times. 
    * 
    * It is exactly 69 weeks (or 483 days) leading up to the 11/01/2023 date.
    */
    @Test
    public void testDaysBetweenJuly_6_2022_and_November_01_2023() {
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
}
