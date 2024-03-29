package com.codified.esword.dao;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.codified.esword.constants.BibleConstants.NUMBER_GRACE_UPON_GRACE_25;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2023_10_07_Test {
    // 
    // Event 10/07/2023 - October 7th, 2023 - The start of the (1290 * 2) timeline
    //
    // There are 2 timelines
    // God's Timeline   1290 / 30 = 43   (4 + 3) = 7 # for God
    // Man's Timeline   1260 / 30 = 42   (4 + 2) = 6 # for Man

    // Half a week is 1260 days or 1260 / 30 = 42 months
    // A full week is 2520 days or 2520 / 30 = 84 months or 84 / 12 = 7 years
    // 
    // The difference between both timelines 
    //            2580 
    //     minus  2520
    //              60 days
    // 
    @Test
    public void testDaysBetweenOctober_7_2023_and_October_30_2030() {
        long daysBetween = DAYS.between(
            LocalDate.of(2023,10,7),
            LocalDate.of(2030,10,30)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==2580);
    }

    // The 2580 timeline starts 60 days in advance before Man's Timeline and it starts
    // on October 7th, 2023
    @Test
    public void testDifferenceInDaysBetweenBothTimelinesIs60() {
        long godsTimeline = 1290;
        long mansTimeline = 1260;
        long diffInDays = (godsTimeline * 2) - (mansTimeline * 2);
        assertTrue(diffInDays == 60);
        // The difference in days between both timelines is 60 days
        // 10/07/2023 - Starts the (1290 * 2) timeline (which is 2580 days)
        // 12/06/2023 - Starts the (1260 * 2) timeline (which is 2520 days)
        //              December 6, 2023 is the start of Daniel's 70th week
        long daysBetween = DAYS.between(
            LocalDate.of(2023,10,7),
            LocalDate.of(2023,12,6)
        );
        assertTrue(daysBetween == 60);
    }

    // I created this file on 9/28/2023 before the Hamas Attack on Israel
    // but before adding these tests, the 10/7/2023 (start of tribulation)
    // date was already on my timeline months before the attack happened
    // https://time.graphics/line/566988
    // https://www.brighteon.com/4594643d-d344-472f-b8e7-3caa2238f4b2
    @Test
    public void testDaysBetweenSeptember_30_2007_and_October_7_2023() {
        long daysBetween = DAYS.between(
            LocalDate.of(2007,9,30),
            LocalDate.of(2023,10,7)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==5851);
        // H5851 - H5850 - H5849 - a primitive root; to encircle (for attack or protection);
        //   especially to crown (literally or figuratively): - compass, crown
        // Total KJV occurrences: 7 
    }

    @Test
    public void testDaysBetweenOctober_7_2023_and_December_6_2023() {
        // Confirm and validate the start dates for both timelines
        // (1290*2 [God's timeline]) vs. (1260*2 [Man's timeline]) is 60 days apart
        LocalDate localDate = LocalDate.of(2023,10,07).plusDays(60);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==12);
        assertTrue(day==6);
        assertTrue(year==2023);
    }

    @Test
    public void testDaysBetweenOctober_7_2023_and_November_1_2023() {
        long daysBetween = DAYS.between(
            LocalDate.of(2023,10,7),
            LocalDate.of(2023,11,1)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==NUMBER_GRACE_UPON_GRACE_25);
        // Confirmatory test: 
        // SearchDAOImpl_25_Matches_Test:
        //   testSearchByKeyword_H1290_AndContext_OldTestament
    }
}
