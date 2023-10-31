package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2023_11_01_Test {
    // 
    // Event 11/01/2023 - November 1, 2023 - Day of the Flood
    //
    // Revelation 8:8  And the second angel sounded, and as it were a great mountain burning with
    // fire was cast into the sea: and the third part of the sea became blood; 
    //
    // Amos 8:8  Shall not the land tremble for this, and every one mourn that dwelleth therein?
    // and it shall rise up wholly as a flood; and it shall be cast out and drowned, as by 
    // the flood of Egypt. 
    //
    // Daniel 9:26  And after threescore and two weeks shall Messiah be cut off,
    // but not for himself: and the people of the prince that shall come shall destroy 
    // the city and the sanctuary; and ***the end thereof shall be with a flood***, and unto 
    // the end of the war desolations are determined.
    //
    // Deuteronomy 18:22  When a prophet speaketh in the name of the LORD, if the thing 
    // follow not, nor come to pass, that is the thing which the LORD hath not spoken, 
    // but the prophet hath spoken it presumptuously: thou shalt not be afraid of him. 
    //
    // Isaiah 46:9   Remember the former things of old: for I am God, and there is none
    //   else; I am God, and there is none like me, 
    //
    // Isaiah 46:10  Declaring the end from the beginning, and from ancient times the 
    //   things that are not yet done, saying, My counsel shall stand, and I will do all 
    //   my pleasure: 
    //
    // Isaiah 46:11  Calling a ravenous bird from the east, the man that executeth my 
    //   counsel from a far country: yea, I have spoken it, I will also bring it to pass; 
    //   I have purposed it, I will also do it.

    // TODO: finish the ways you derived the date
    // The many ways I derived this date
    // 
    

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

    @Test
    public void testDaysBetween11_01_2001_and_10_30_2030() {
        // Calculate the number of days between 11/01/2001 and 10/30/2030
        long daysBetween = DAYS.between(
            LocalDate.of(2023,11,1),
            LocalDate.of(2030,10,30)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==2555);
        // H2555 - From H2554; violence; by implication wrong; by metonymy unjust gain: 
        // - cruel (-ty), damage, false, injustice, X oppressor, unrighteous, 
        // violence (against, done), violent (dealing), wrong.
    }

    @Test
    public void testSubtract35Days_From_November_1_2023() {
        // If we were to use the 2520 clock and divide by 35, we get 72
        // The pattern is 35 days of punishment, 70 days, then 35 days of punishment
        // So the clock without punishment has to be set at 71*35, which is 2485
        // If we subtract 2485 from 11/01/2023, we get another 111 date which is
        // 1/11/2017
        LocalDate localDate = LocalDate.of(2023,11,1).minusDays(2485);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==1);
        assertTrue(day==11);
        assertTrue(year==2017);
    }

    // Countdown timer expiring at D-day which is 11/01/2023
    // Timer is divisible by 13 in 622 parts
    // The number 13 - symbolizes rebellion & lawlessness
    //
    @Test
    public void test8086CountdownClockBetween9_11_2001_and_11_1_2023() {
        // Calculate the countdown clock between 9/11/2001 and 11/1/2023
        long daysBetween = DAYS.between(
            LocalDate.of(2001,9,11),
            LocalDate.of(2023,11,1)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==8086);
        int part = 8086 / 13;
        assertTrue(part == 622);
        // G622 - apollumi - ap-ol'-loo-mee - From G575 and the base of G3639; 
        //   to destroy fully (reflexively to perish, or lose), 
        //   literally or figuratively: - destroy, die, lose, mar, perish.
    }

    // Countdown timer expiring 1 day before D-day which is 11/01/2023
    // Timer is divisible by 11 in 735 parts
    // The number 11 - symbolizes disorder, chaos and judgment
    // Pattern for the timer is (11+1)
    @Test
    public void test8085CountdownClockBetween9_11_2001_and_10_31_2023() {
        // Calculate the countdown clock between 9/11/2001 and 11/1/2023
        long daysBetween = DAYS.between(
            LocalDate.of(2001,9,11),
            LocalDate.of(2023,10,31)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==8085);
        int part = 8085 / 11;
        assertTrue(part == 735);
        // G736 - properly something ready; something hung up, that is
        // specifically the topsail of a vessel: - mainsail
        //
        // This is the day before D-day which is 11/01/2023
        // Notice the pattern 8085 * 11 clock, when this clock is expired,
        // it's only 1 more day to 111; so the pattern is 
        // (735*11 countdown clock)+1 day 
        // or simply (735*11)+1
    }
}
