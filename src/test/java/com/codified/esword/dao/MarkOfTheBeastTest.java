package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.parser.Part;

import com.codified.esword.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MarkOfTheBeastTest {

    @Test
    //
    // G954
    // Βεελζεβούλ
    // Beelzeboul
    // beh-el-zeb-ool'
    // Of Chaldee origin (by parody upon [H1176]); dung god; Beelzebul, a name of Satan: - Beelzebub.
    // Total KJV occurrences: 7
    //
    // Isaiah 66:7  Before she travailed, she brought forth; before her pain came, 
    // she was delivered of a man child. 
    //
    // Revelation 12:5  And she brought forth a man child, who was to rule all nations with a rod of iron: and 
    // her child was caught up unto God, and to his throne. 
    //
    public void testDaysBetweenSeptember_23_2017_and_May_4_2020() {
        long daysBetween = DAYS.between(
            LocalDate.of(2017,9,23),
            LocalDate.of(2020,5,4)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==954);  
    }
    
    
}
