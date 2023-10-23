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

    // H1335 - part, piece
    //
    //   1335 divided by 5 parts = 267
    //     g267 - witness or g3144 witnesses
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
    //   1332 / 2 = 666
    // 
    // So the pattern is
    //  (666 + 666) + 3 days
    //    
    // 3/5/2027 + 1332 days          = 10/27/2030 (Yah/Jah is most vehement at this point)
    // 3/5/2027 + 1332 days + 3 days = 10/30/2030
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
    }
}
