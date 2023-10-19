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

    // Little boy named El Elyon
    // https://youtu.be/NpCxK1OkqdE?start=9&end=54
    //
    // Luke 21:8  And he said, Take heed that ye be not deceived: for many shall come in my name, 
    // saying, I am Christ; and the time draweth near: go ye not therefore after them.
    // 
    // https://newcreeations.org/names-of-god/?gad=1
    //
    // El Elyon (The Most High God)
    // 
    // First seen in Genesis 14:18 – Used 52 times in the Bible (sometimes without El, 
    // simply as Elyon)
    //
    // El is likely related to the word Elohim and is used in conjunction with other 
    // descriptive words to specifically reference a particular characteristic of God. 
    // Elyon means highest or most high. Used together El Elyon means The Most High God. 

    
    
}
