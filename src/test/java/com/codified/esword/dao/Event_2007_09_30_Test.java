package com.codified.esword.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Event_2007_09_30_Test {
    //
    // Event 09/30/2007 - September 30th, 2007 - The Four Horsemen meet in Washington, D.C.
    //
    // The "Apocalypse" commencement starts with the arrival of the Four Horsemen.
    // Although the Word of Man states that they are not the horsemen from the Apocalypse,
    // the Word of God does indeed point to this very day as a significant event in the 
    // Revelations Timeline.
    //
    // On 30 September 2007, Dawkins, Harris, Hitchens and Dennett met at Hitchens' residence
    // in Washington, D.C., for a private two-hour unmoderated round table discussion. 
    // The event was videotaped and titled "The Four Horsemen". During "The God Debate" in 
    // 2010 with Hitchens versus Dinesh D'Souza, the group was collectively referred to 
    // as the "Four Horsemen of the Non-Apocalypse", an allusion to the biblical Four Horsemen
    // of the Apocalypse from the Book of Revelation. The four have been described as 
    // "evangelical atheists".
    //
    // The Four Horsemen HD: Hour 1 of 2 - Discussions with Richard Dawkins, Ep 1
    // https://youtu.be/9DKhc1pcDFM?si=8wB9dLZLLQMPqUob
    // The Four Horsemen: Hour 2 of 2 - Discussions with Richard Dawkins, Ep 1
    // https://youtu.be/TaeJf-Yia3A?si=eYSxrMbMvz_3LEW1
    //
    // https://web.archive.org/web/20230829061516/http://en.wikipedia.org:80/wiki/New_atheism
    // 
    
    // Revelation 9:18-19
    // Rev 9:18  By these three was the third part of men killed, by the fire, and by the smoke,
    //   and by the brimstone, which issued out of their mouths. 
    // Rev 9:19  For their power is in their mouth, and in their tails: for their 
    //   tails were like unto serpents, and had heads, and with them they do hurt. 
    // The important keywords to extract from Revelation 6:2-8, 9:1-19 based on the context
    // of all verses are: HORSES, MEN, HORSEMEN
    // 
    // By these three was the third part of men killed 
    // By these three - since we extracted the root context word HORSEMEN from
    // Revelation 9:1-18, The Bible is inferring to the 3 out of the 4 horsemen
    
     // Christopher Hitchens
    //   https://www.brainyquote.com/authors/christopher-hitchens-quotes
    //   https://abcnews.go.com/blogs/headlines/2011/12/hitchens-remembered-through-15-of-his-most-memorable-quotes
    // Richard Dawkins
    //   https://www.brainyquote.com/authors/richard-dawkins-quotes
    // Sam Harris
    //   https://www.brainyquote.com/authors/sam-harris-quotes
    // Daniel Dennett
    //   https://www.brainyquote.com/authors/daniel-dennett-quotes

    // H5876
    // עֵין חַדָּה
    // ‛êyn chaddâh
    // ane khad-daw'
    // From H5869 and the feminine of a derivative from H2300; fountain of sharpness; En-Chaddah, a place in Palestine: - En-haddah.
    // Total KJV occurrences: 1
    //   Look into derivative root H2300
    // 
    // H2300
    // חָדַד
    // châdad
    // khaw-dad'
    // A primitive root; to be (causatively make) sharp or (figuratively) severe: - be fierce, sharpen.
    // Total KJV occurrences: 6
    @Test
    public void testDaysBetweenSeptember_30_2007_and_November_1_2023() {
        long daysBetween = DAYS.between(
            LocalDate.of(2007,9,30),
            LocalDate.of(2023,11,1)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==5876);
        // H5876 - the root derivative meaning is H2300
    }

    // What is going to be sharpened on 11/01/2023?
    //
    // Isaiah 5:28  Whose arrows are sharp, and all their bows bent, their horses' hoofs 
    //     shall be counted like flint, and their wheels like a whirlwind: 
    // Isaiah 5:29  Their roaring shall be like a lion, they shall roar like young lions: 
    //     yea, they shall roar, and lay hold of the prey, and shall carry it away safe, 
    //     and none shall deliver it. 
    // Isaiah 5:30  And in that day they shall roar against them like the roaring of the sea: 
    //     and if one look unto the land, behold darkness and sorrow, and the light is 
    //     darkened in the heavens thereof. 

    // H8431
    // תּוֹחֶלֶת
    // tôcheleth
    // to-kheh'-leth
    // From H3176; expectation: - hope.
    // Total KJV occurrences: 6
    //
    // https://github.com/rsanluis/esword-cli/blob/main/images/events/2007_09_30/h8431_meaning.png
    @Test
    public void testDaysBetweenSeptember_30_2007_and_October_30_2030() {
        long daysBetween = DAYS.between(
            LocalDate.of(2007,9,30),
            LocalDate.of(2030,10,30)
        );
        log.info("daysBetween: {}", daysBetween);
        assertTrue(daysBetween==8431);
    }
}
