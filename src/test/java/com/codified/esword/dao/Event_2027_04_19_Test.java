package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2027_04_19_Test {
    //
    // Event 04/19/2027 - April 19th, 2027
    //
    // This is the midpoint of the 1290 [God's timeline] * 2 = 2580
    //

    // Daniel 12:11  And from the time that the regular burnt offering is taken away and the 
    // abomination that makes desolate is set up, there shall be 1,290 days.  

    // Since we know the End Date being 10/30/2030; 
    // Since 1260 is represents half a week; we had to multiply by 2 to get 2520 for Man's timeline
    // Likewise, we have to multiply by 
    // We can subtract 2580 days from the End Date to get the start 
    // of the entire timeline, which is 10/7/2023
    @Test
    public void testSubtracting2580Days_From_October_30_2030() {
        LocalDate localDate = LocalDate.of(2030,10,30).minusDays(2580);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==10);
        assertTrue(day==7);
        assertTrue(year==2023);
    }

    // Start    of 1290 * 2  [God's timeline] is October 7, 2023
    // Midpoint of 1290 * 2  [God's timeline] is April  19, 2027
    @Test
    public void testDaysBetweenOctober_7_2023_and_April_19_2027() {
        long daysBetween = DAYS.between(
            LocalDate.of(2023,10,7),
            LocalDate.of(2027,4,19)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==1290);
    }

    @Test
    public void testDaysBetweenApril_19_2027_and_October_30_2030() {
        long daysBetween = DAYS.between(
            LocalDate.of(2027,4,19),
            LocalDate.of(2030,10,30)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==1290);
    }

}


