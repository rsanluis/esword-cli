package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2030_10_30_Test {
    //
    // Event 10/30/2030 - The Day of the Lord
    //                    The Second Coming of Christ
    //
    // Revelation 1:7  Behold, he cometh with clouds; and every eye shall see him, and they
    // also which pierced him: and all kindreds of the earth shall wail because of him. 
    // Even so, Amen. 
    //
    // Matthew 24:27 - For as the lightning cometh out of the east and shineth even unto the 
    // west, so shall also the coming of the Son of Man be.
    // 
    // 1 Thessalonians 4:14  For if we believe that Jesus died and rose again, even so them 
    // also which sleep in Jesus will God bring with him. 
    //
    // 1 Thessalonians 4:17  Then we which are alive and remain shall be caught up together
    // with them in the clouds, to meet the Lord in the air: and so shall we ever be with the Lord.
    //
    // Revelation 11:11  And after three days and an half the Spirit of life from God entered 
    // into them, and they stood upon their feet; and great fear fell upon them which saw them. 
    // 
    // 1 Corinthians 15:52  In a moment, in the twinkling of an eye, at the last trump: for the
    // trumpet shall sound, and the dead shall be raised incorruptible, and we shall be changed. 
    // 
    // Jeremiah 8:1  At that time, saith the LORD, they shall bring out the bones of the kings
    // of Judah, and the bones of his princes, and the bones of the priests, and the bones of
    // the prophets, and the bones of the inhabitants of Jerusalem, out of their graves: 
    //
    // Start week: 12/06/2023
    // Mid   week:  5/19/2027 (12/06/2023 + 1260 days)
    // End   week: 10/30/2030 ( 5/19/2027 + 1260 days)
   
    // Both timelines converge and land on the same end date: 10/30/2030
    @Test
    public void testDaysBetweenOctober_7_2023_and_October_30_2030() {
        LocalDate localDate = LocalDate.of(2023,10,07).plusDays(2580);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==10);
        assertTrue(day==30);
        assertTrue(year==2030);
    }

    @Test
    public void testDaysBetweenDecember_6_2023_and_October_30_2030() {
        LocalDate localDate = LocalDate.of(2023,10,07).plusDays(2560);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==10);
        assertTrue(day==30);
        assertTrue(year==2030);
    }
}
