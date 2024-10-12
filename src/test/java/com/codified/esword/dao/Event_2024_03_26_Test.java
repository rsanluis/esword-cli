package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2024_03_26_Test {
    //
    // Event 03/26/2024 - March 26th, 2024 - 111 days after the Start of Tribulation (12/6/2023)
    // Test created on: 10/12/2024
    //
    // I only noticed this event after the fact it happened but I noticed it aligned with the 111 pattern
    //   111 days after 12/6/2023 happens to be 3/26/2024 
    // 
    // What happened on 3/26/2024?  The Francis Scott Key Bridge collapse
    // https://en.wikipedia.org/wiki/Francis_Scott_Key_Bridge_collapse
    // https://edition.cnn.com/us/live-news/baltimore-bridge-collapse-03-26-24-intl-hnk/index.html
    // 
    @Test
    public void testAdd_111_Days_from_December_6_2023() {
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





