package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2027_03_05_Test {
    //
    // Event 03/05/2027 - March 5th, 2027
    //
    // Dan 12:12  Blessed is he that waiteth, and cometh to the thousand three hundred and
    //   five and thirty days. 
    @Test
    public void testSubtract_1335_Days_from_October_30_2030() {
        // H1335 - part, piece
        //
        // 1335 divided by 5 parts = 267
        //
        // G267 - witness or g3144 witnesses
        //
        LocalDate localDate = LocalDate.of(2030,10,30).minusDays(1335);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==3);
        assertTrue(day==5);
        assertTrue(year==2027);
    }
    
    // G69
    // ἀγρυπνέω
    // agrupneō
    // ag-roop-neh'-o
    // Ultimately from G1 (as negative particle) and G5258; to be sleepless, that is, keep awake: - watch.
    // Total KJV occurrences: 4
    //
    // 69 represents the prophet Roland Resurreccion San Luis in the following verses:
    // G69 - watch, watching (all uses of G69 in the King James Bible)
    //
    // Deuteronomy 18:15  The LORD thy God will raise up unto thee a Prophet from 
    // the midst of thee, of thy brethren, like unto me; unto him ye shall hearken; 
    // 
    // Deuteronomy 18:18  I will raise them up a Prophet from among their brethren, like unto
    // thee, and will put my words in his mouth; and he shall speak unto them all that 
    // I shall command him. 
    //
    // Deuteronomy 18:19  And it shall come to pass, that whosoever will not hearken unto my
    // words which he shall speak in my name, I will require it of him. 
    // 
    // Deuteronomy 18:22  When a prophet speaketh in the name of the LORD, if the thing follow
    // not, nor come to pass, that is the thing which the LORD hath not spoken, but the prophet 
    // hath spoken it presumptuously: thou shalt not be afraid of him. 
    //
    // Isaiah 46:11  Calling a ravenous bird from the east, the man that executeth my counsel
    // from a far country: yea, I have spoken it, I will also bring it to pass; I have 
    // purposed it, I will also do it. 
    @Test
    public void testDaysBetweenMarch_5_2027_and_May_13() {
        long daysBetween = DAYS.between(
            LocalDate.of(2027,3,5),
            LocalDate.of(2027,5,13)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==69);
    }
    
}
