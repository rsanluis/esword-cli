package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropheticClock_BaseTest {

    // Video explanation for 1260 and 1290 timelines
    // https://www.brighteon.com/28395dab-b000-4206-947e-ed4939496167

    // God and Man's prophetic clock are key to solving and unlocking the mysteries of
    // Revelation and Daniel
    //
    // 3-6-9  is God's prophetic clock
    //   1) Think of this like a clock that expires in the midnight position
    //   2) We add up the numbers of the first 2, we get 9
    //   3) We multiply the numbers of the first 2, we get 18
    //   4) When it hits the midnight position, it expires at 18
    //
    // 3-7-10 is Man's prophetic clock
    //   1) Think of this like a clock that expires in the midnight position
    //   2) We add up the numbers of the first 2, we get 10
    //   3) We multiple the numbers of the first 2, we get 21
    //   4) When it hits the midnight position, it expires at 21
    //
    // 
    // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/18.html
    //
    // When each clock expires, it signifies a symbolic meaning
    //   at expiry at 18, it signifies bondage
    //   at expiry at 21, it signifies great wickedness of rebellion and sin
    //
    // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/18.html
    // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/21.html
    //
    // Daniel 9:24  Seventy weeks are determined upon thy people and upon thy holy city, 
    // to finish the transgression, and to make an end of sins, and to make 
    // reconciliation for iniquity, and to bring in everlasting righteousness, and 
    // to seal up the vision and prophecy, and to anoint the most Holy.
    //
    // If 70 weeks are decreed or determined upon thy people, how does that number fit
    // the prophetic clocks of 3-6-9 and 3-7-10?
    //
    // 2520 is the prophetic clock that pertains to man
    // First let's expand the 2520 based on Biblical pattern
    //   The number of man 6 times the number of man 6 * 70 weeks decreed
    //   (6*6) * 70 = 2520
    //
    //   Since 2520 represents the entire tribulation, which is 7 years;
    //   we must split 2520 in half and work with half a week, which is 1260 
    //
    //   Here's the pattern & it's solved through simple Math:
    //     1) 1260
    //     2)
    //        Find the common unit to be used between both 3-6-9 and 3-7-10 clocks 
    //        (18)                (21)
    //        ----                ----
    //        3*6*7*10            3*6*7*10
    //        (18)*70             (21)*60
    //
    //   Notice that we don't expand 10 since it is God's ordinal value
    //   When the (18) clock strikes midnight, it coincides with 18 within the 3-6-9 clock
    //     and the other value is 70 which matches the same number determined for man.
    //   When the (21) clock strikes midnight, the value is set at 60
    //     21*60=1260
    //   
    //   Since the (18) clock has 70 units, which matches with 70 decreed to man, we will not
    //     use 70 to find a common divisor; plus it does not divide cleanly
    //
    //   Let's divide both timelines by 60
    //   1290 * 2 = 2580 / 60 = 43
    //   1260 * 2 = 2520 / 60 = 42
    // 
    //   So now we have 2 clocks
    //   God's timeline with 43 units * 60 units = 2580
    //   Man's timeline with 42 units * 60 units = 2520
    //        and the difference between the 2 is    60 units

    // 3-6-9
    // https://www.youtubetrimmer.com/view/?v=iMbROIZMxaE&start=49&end=78&loop=0
    @Test
    public void testPropheticClock_3_6_9() {
        // Now let's test this out for a half a week; which is 1260 days
        // 1260 days / 60 days
        // 21 - it matches half of a full week (42)
        int units = (1260 / 60);
        assertTrue(units == 21);
        // The full clock for Man (3-6-9) is represented by 2520 / 60
        units = (2520 / 60);
        assertTrue(units == 42);
        // https://github.com/rsanluis/esword-cli/blob/main/images/prophetic_clock/mans_timeline_1260.png
    }

    // 3-7-10
    // https://www.youtubetrimmer.com/view/?v=dvywOjh_hdY&start=68&end=80&loop=0
    @Test
    public void testPropheticClock_3_7_10() {
        // Now let's test this out for a half a week; which is 1290 days
        // 1290 days / 60 days
        // 21.5 - it matches half of a full week (43)
        double units = (1290d / 60d);
        assertTrue(units == 21.5d);
        assertTrue(units * 2 == 43); // Double the units; should equal 43
        // The full clock for Man (3-7-10) is represented by 2580 / 60
        units = (2580 / 60);
        assertTrue(units == 43); 
        // https://github.com/rsanluis/esword-cli/blob/main/images/prophetic_clock/gods_timeline_1290.png
    }

    // By the explanation above, now you have the notion of 2 clocks
    // When they expire at the midnight position; you get the following
    // (1290*2) = 2580 / 60 = 43
    // (1260*2) = 2520 / 60 = 42

    // Now doing an occurence match for 60 from the King James Bible gives us something 
    // interesting:
    // 
    // https://github.com/rsanluis/esword-cli/blob/main/images/prophetic_clock/wordmatch_context_bible_matches_60.png
    //
    // We get a list of words with an occurrence rate of exactly 60 in the King James Version Bible
    // One of the few words that catches my attention is h2555, nebuchandnezzar, h7379
    //   h2555 - cruelty, wrong, false, violence
    //   nebuchandnezzar - which represents worshipping a false idol of 60 cubits
    //   h3739 - contest, strife, controversy
    //
    // 60 units represents the threshold for cruelty, wrongdoing, strife, false worship, etc.
    //
    // At 60*43 God's clock expires (in the Midnight position) 
    // At 60*42 Man's clock expires (in the Midnight position)
    // 
    // 2580 God's timeline
    // 2520 Man's timeline
    // ---- subtract
    //   60 units ahead (for God's timeline)
    //
    // https://time.graphics/line/566988
    // In the timeline I created above, you'll see the start dates for the
    // Both (1290 * 43) and (1260 * 42) timelines start on different dates but
    // converge or land on the same date 10/30/2030
}
