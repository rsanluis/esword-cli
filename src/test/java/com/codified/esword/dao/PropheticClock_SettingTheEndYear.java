package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import static com.codified.esword.constants.BibleConstants.NUMBER_OF_MAN_6;
import static com.codified.esword.constants.BibleConstants.NUMBER_DIVINE_COMPLETION_7;
import static com.codified.esword.constants.BibleConstants.NUMBER_ORDINAL_PERFECTION_10;

@Slf4j
// Fulfilled Prophecy: Evidence for the Reliability of the Bible
// https://reasons.org/explore/publications/articles/fulfilled-prophecy-evidence-for-the-reliability-of-the-bible
// 
@SpringBootTest
public class PropheticClock_SettingTheEndYear {
    // Setting the end year to know where the goal posts are

    // The following are excellent videos to watch how they cross reference
    // verses to come up with the year of the Lord's return

    // Messiah 2030 ~ The Prophetic Messianic Timeline - Part 1
    // https://www.youtube.com/watch?v=4AG_nJNcTjM
    
    // Messiah 2030 ~ The Prophetic Messianic Timeline - Part 2
    // https://www.youtube.com/watch?v=AwsjrcUtNhU

    // 2023 END-TIMES PROPHECY (70th Week of Daniel Revealed)
    // https://www.youtube.com/watch?v=aw2p06bgyKg

    @Test
    public void testSettingTheEndYear_2030() {
        // Basically     36  * 70 = 2520 (total time for man's clock)
        // minus          7  * 70 =  490 (time served/decreed for redemption)
        //               29  * 70 = 2030
        int mansClock = (NUMBER_OF_MAN_6 * NUMBER_OF_MAN_6) 
            * NUMBER_DIVINE_COMPLETION_7 
            * NUMBER_ORDINAL_PERFECTION_10;
        int timeServedForRedemption = NUMBER_DIVINE_COMPLETION_7
            * NUMBER_DIVINE_COMPLETION_7 
            * NUMBER_ORDINAL_PERFECTION_10;
        int endYear = mansClock - timeServedForRedemption;
        log.info("endYear: {}", endYear);
        assertTrue(endYear == 2030);
    }

    // 2 Peter 3:8  But, beloved, be not ignorant of this one thing, that one day is with the Lord 
    // as a thousand years, and a thousand years as one day. 
    @Test
    public void testSettingTheEndYear_ByRule_1_Day_is_1000_Years_and_1000_Years_as_1_Day() {
        // 1000 * 360 / 24 / 360 = can be simplified as just 1000/24
        double formula = 1000d / 24d;
        double valueFor1Hour = 41d + (2d/3d);
        assertTrue(formula == valueFor1Hour);
        double endYear = 30d + (24d * valueFor1Hour) * 2; // multiply by 2 days
        assertTrue(endYear == 2030);
    }
}
