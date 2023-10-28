package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
public class Event_2030_10_27_Test {
    //
    // Event 10/27/2030 - October 27th, 2030
    //
    // This date is a derived and calculated date based on the 3/5/2027 date.
    // Dan 12:12  Blessed is he that waiteth, and cometh to the thousand three hundred and
    //   five and thirty days. 
    //
    // The 3/5/2027 date is 1335 days before the day of the Lord.
    //
    // From Daniel *** 12:12 *** we see the emphasis of seeing 12 twice; it's a sign to divide
    // 1335 / 12 = (111 & 1/4)
    //   We can now rewrite the equation like the following:
    //   12 * (111 & 1/4) = 1335
    //   12 * 111 + (12 * 1/4) = 1332 + 3
    //   Let's inspect the 1st number *** 1332 ***
    //
    // H1332 - leads to root Hebrew H3050 which is yah
    //
    // H3050
    // יָהּ
    // yâhh
    // *** yaw ***
    // Contracted for H3068, and meaning the same; Jah, the sacred name: - Jah, the Lord, 
    //   most vehement. Cp. names in “-iah,” “-jah.”
    // Total KJV occurrences: 49
    //   
    // Jah or *** Yah *** (Hebrew: Yāh) is a short form of יהוה (YHWH), the four letters that form
    //   the tetragrammaton, the personal name of God
    // 
    // Inspecting G1332 leads to G1364, which means twice: - again, twice
    //   That leads us into splitting God's name into 2
    //   1332 / 2 = 666   which is the number for Christos
    // 
    // Since H1335 is a part; a piece, a section
    //
    // So the pattern is 2 parts of 666 + 3 days
    //  |666| + |666| + 3 days  = 10/30/2027     The second coming of Christ
    //  Leaving off the 3 days  = 10/27/2027     The day the 2 prophets die
    // 
    // Mark 14:72  And the second time the cock crew. And Peter called to mind the word that
    // Jesus said unto him, Before the cock crow twice, thou shalt deny me thrice. 
    // And when he thought thereon, he wept. 
    //
    // 666 represents Christos in English Gematria
    // https://www.gematrix.org/?word=christos
    // https://github.com/rsanluis/esword-cli/blob/main/images/names_of_god/Christos.png
    //
    // |Deny Christ|+|Deny Christ|=Before the cock crow twice 
    // From 03/05/2027 to 10/27/2030 is 1332 day which represents the 2 date ranges
    //   for people to deny Christ
    // To get the midpoint, we add 666 days to 03/05/2027
    // December 30, 2028 is the midpoint 
    // https://www.timeanddate.com/date/dateadded.html?d1=5&m1=3&y1=2027&type=add&ay=&am=&aw=&ad=666&rec=
    //    
    // 3/5/2027 + 1332 days          = 10/27/2030 (Yah/Jah is most vehement at this point)
    // 3/5/2027 + 1332 days + 3 days = 10/30/2030 Christ returns to raise the dead and judge the living
    @Test
    public void testAdd_1332_Days_from_March_5th_2027() {
        LocalDate localDate = LocalDate.of(2027,3,5).plusDays(1332);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==10);
        assertTrue(day==27);
        assertTrue(year==2030);
        // Since H1335 is a part; a piece, a section
        int oneOfTwoParts = 1332 / 2; 
        assert(oneOfTwoParts == 666);
        int denyMe3Times  = 1332 / 3;
        assert(denyMe3Times == 444); 
        // G444: men will deny me three times before 10/27/2023
        //
        // Period of waiting starts on 3/5/2027
        // cock crow1 | cock crow2 | 10/27/2023     | + 3 days | 10/30/2030
        //    666     |    666     | 2 prophets die |          | 2nd coming of Christ
        // |        666 * 2 = 1332 days             |
    }
}
