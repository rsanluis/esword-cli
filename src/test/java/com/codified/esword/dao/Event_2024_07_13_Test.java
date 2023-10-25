package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2024_07_13_Test {
    //
    // Event 07/13/2027 - July 13th, 2024 - 2300 days then shall the santuary be cleansed
    //
    // Daniel 8:13  Then I heard one saint speaking, and another saint said unto that
    //   certain saint which spake, How long shall be the vision concerning the daily 
    //   sacrifice, and the transgression of desolation, to give both the sanctuary and
    //   the host to be trodden under foot? 
    //
    // Daniel 8:14  And he said unto me, Unto two thousand and three hundred days; 
    //    then shall the sanctuary be cleansed. 
    //
    @Test
    public void testSubtract_2300_Days_from_October_30_2030() {
        LocalDate localDate = LocalDate.of(2030,10,30).minusDays(2300);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==7);
        assertTrue(day==13);
        assertTrue(year==2024);
    }
    
}





