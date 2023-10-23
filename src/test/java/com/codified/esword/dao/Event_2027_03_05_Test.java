package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2027_03_05_Test {
    // Event 03/05/2027 - March 5th, 2027

    // Dan 12:12  Blessed is he that waiteth, and cometh to the thousand three hundred and
    //   five and thirty days. 
    @Test
    public void testSubtract_1335_Days_from_October_30_2030() {
        LocalDate localDate = LocalDate.of(2030,10,30).minusDays(1335);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==3);
        assertTrue(day==5);
        assertTrue(year==2027);
    }

    // From Daniel we see the emphasis of seeing 12 twice; it's a sign to divide
    // 1335 / 12 = 111 and 1/4
    // We can now rewrite the equation like the following:
    //     
    @Test
    public void testAdd_1332_Days_from_March_5th_2027() {
        LocalDate localDate = LocalDate.of(2030,10,30).minusDays(1335);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==3);
        assertTrue(day==5);
        assertTrue(year==2027);
    }


}
