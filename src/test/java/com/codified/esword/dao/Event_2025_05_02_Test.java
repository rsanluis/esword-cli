package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2025_05_02_Test {
    //
    // Event 05/02/2025 - May 2nd, 2025 - The Command To Speak on this Day
    // Test created on: 10/12/2024
    //
    // Deuteronomy 18:20 -  But the prophet, which shall presume to speak a word in my name, which I have not *** commanded him to speak ***, 
    //   or that shall speak in the name of other gods, even that prophet shall die. 
    // 
    // Adding 513 days to the Start of Tribulation yields the date: May 2nd, 2025
    // It is the command for me to speak on this very day (5/2/2025)
    // 
    // I had unlocked the number 30 within my previous test: testWordMatchesDanRev_30_Matches_Test 
    // 69  * 7  = 483  
    // 483 + 30 = 513  
    // 
    // 513 are the first 3 digits of my birthday - God only gives this command to the person who unlocks his secrets
    // 
    // How do I know that the command is to speak?
    // You can see it in test: testWordMatchesBible_CommandGivenFromBibleBasedOnFirst3DigitsOfMyBday
    // 
    // The only word that has 513 matches or occurences in the entire KJV bible is the word: speak
    //
    @Test
    public void testAdd_513_Days_from_December_6_2023() {
        LocalDate localDate = LocalDate.of(2023,12,6).plusDays(513);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
        assertTrue(month==5);
        assertTrue(day==2);
        assertTrue(year==2025);
    }
}





