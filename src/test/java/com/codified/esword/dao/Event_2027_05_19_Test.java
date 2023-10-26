package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
public class Event_2027_05_19_Test {
    //
    // Event 05/19/2027 - May 19th, 2027 - Mid Week of Man's Timeline (1260 * 2) 
    // 
    // Daniel 9:27  And he shall confirm the covenant with many for one week: and 
    // in the ***midst*** of the week he shall cause the sacrifice and the oblation to cease, 
    // and for the overspreading of abominations he shall make it desolate, even until 
    // the consummation, and that determined shall be poured upon the desolate. 
    // 
    // Matthew 24:15  When ye therefore shall see the abomination of desolation, 
    // spoken of by Daniel the prophet, stand in the holy place, (whoso readeth, 
    // let him understand:) 
    // Matthew 24:16  Then let them which be in Judaea flee into the mountains
    
    @Test
    public void testDaysBetweenDecember_6_2023_and_May_19_2027() {
        // Test start point to mid point of (1260 * 2) [Man's timeline]
        // Start point: 12/06/2023
        // Mid point: 5/19/2027
        LocalDate localDate = LocalDate.of(2023,12,6).plusDays(1260);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==5);
        assertTrue(day==19);
        assertTrue(year==2027);
    }
}
