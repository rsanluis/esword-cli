package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SignatureOfThisProjectTest {

    @Autowired
    SearchDAO searchDAO;

    /*
     * John 3:3  Jesus answered and said unto him, Verily, verily, I say unto thee, Except a man be born again, he cannot see the kingdom of God. 
     * John 3:4  Nicodemus saith unto him, How can a man be born when he is old? can he enter the second time into his mother's womb, and be born? 
     * John 3:5  Jesus answered, Verily, verily, I say unto thee, Except a man be born of water and of the Spirit, he cannot enter into the kingdom of God. 
     * John 3:6  That which is born of the flesh is flesh; and that which is born of the Spirit is spirit. 
     * John 3:7  Marvel not that I said unto thee, Ye must be born again. 
     * 
     * Matthew 11:25 At that time Jesus answered and said, I thank thee, O Father, 
     * Lord of heaven and earth, because thou hast hid these things from the wise 
     * and prudent, and hast revealed them unto babes.
     *
     * Luke 10:21 In that hour Jesus rejoiced in spirit, and said, I thank thee, 
     * O Father, Lord of heaven and earth, that thou hast hid these things from 
     * the wise and prudent, and hast revealed them unto babes: even so, Father; 
     * for so it seemed good in thy sight.
     * 
     * G3516
     * νήπιος
     * nēpios
     * nay'-pee-os
     * From an obsolete particle νη ne; implying negation and G2031; not speaking, 
     * that is, an infant (minor); figuratively a simple minded person, 
     *          an immature Christian: - babe, child (+ -ish).
     * 
     * God had revealed these things to me, a babe or an immature Christian, which 
     * he later advised me to reveal to his people on 04/05/2023. 
     * Exactly 7 years and 2 days from Baptism.
     * 
     * Babtized at Metro Church on 04/03/2016 by Pastor David Stine
     * https://www.youtube.com/watch?v=D0i8YHJWW1M
     * 
     * O Father, Lord of heaven and earth, that thou hid these things from the wise 
     * and prudent, and hast revealed them unto ***babes***.
     * 
     * I published one of these things that the Lord revealed to me on 4/5/2023.
     * Again, exactly 7 years and 2 days from Baptism.
     * https://www.brighteon.com/01c32949-0170-4f3f-8ec2-9d76497a155b
     */
    @Test
    void testBabes_Test() {
        LocalDate localDate = LocalDate.of(2016,4,3)
            .plusYears(7)
            .plusDays(2);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
            assertTrue(month==4);
            assertTrue(day==5);
            assertTrue(year==2023);
    }
    
    /*
     * Amos 3:7 - Surely the Lord GOD will do nothing, but he revealeth his secret unto 
     * his servants the prophets.
     */
    
    @Test
    void testIsaiah46_9_11() {
        //
        // This is a true story worth retelling, otherwise it will remain forever between myself and 
        // the Lord
        //
        // Within the Year(s):Month(s) away from my birthday 05/13/1976
        //
        // 46th year:9th month - At this time, I had already derived of the 11/01/2023 date for the 
        //         destruction of Babylon (America) and 12/06/2023 for being the start of tribulation.
        //         You can verify the dates on the timeline I created based on Daniel & Revelation:
        //         https://time.graphics/line/566988

        // Birth date of Roland Resurreccion San Luis = 05/13/1976
        LocalDate localDate = LocalDate.of(1976,05,13)
            .plusYears(46)
            .plusMonths(9);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
            assertTrue(month==2);
            assertTrue(day==13);
            assertTrue(year==2023);

        // 46th year:10th month - I prayed and fasted for 10 days (03/01/2023-03/10/2023) with ash 
        // (incense) just like Daniel; asking God, "Should I show this info to your people?"  
        // I prayed to him that, "They won't ever believe me"
        //
        // He showed me other verses that instructed me to utter this info to his people, 
        // no matter if they would like to hear me or not.
        //         Isaiah 48:20 Go ye forth of Babylon, flee ye from the Chaldeans, with a voice of singing declare ye, 
        //         tell this, utter it even to the end of the earth; say ye, The LORD hath redeemed his servant Jacob.
        //
       
        localDate = LocalDate.of(1976,05,13)
            .plusYears(46)
            .plusMonths(10);
        month = localDate.getMonthValue();
        day = localDate.getDayOfMonth();
        year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
            assertTrue(month==3);
            assertTrue(day==13);
            assertTrue(year==2023);
            
        // I followed his advice (counsel) and did the video,
        //         The Exact Date of Babylon's Destruction by Flood (Revealed) on Brighteon.com
        //         on 04/05/2023 (210 days away from D-day)
        //         https://www.brighteon.com/01c32949-0170-4f3f-8ec2-9d76497a155b
        //
        // 46th year:11th month - By the end of April, I was shown the verses in Isaiah (46:9-11) matching
        //         this exact timing of finding God's true timeline, the prayer & fasting, and his advice to
        //         tell his people. It was no coincidence. God is real and listens to our prayers and thoughts.  
        //         This was God telling me that the timeline I have (https://time.graphics/line/566988)
        //         is correct.
        //
        localDate = LocalDate.of(1976,05,13)
            .plusYears(46)
            .plusMonths(11);
        month = localDate.getMonthValue();
        day = localDate.getDayOfMonth();
        year = localDate.getYear();
        log.info("localDate: {}/{}/{}", month, day, year);
            assertTrue(month==4);
            assertTrue(day==13);
            assertTrue(year==2023);

        // Isaiah 46:11 - Calling a ravenous bird from the east, the man that executeth my counsel from a 
        // far country: yea, I have spoken it, I will also bring it to pass; I have purposed it, I will also do it. 
        //
        // This verse holds different meanings for each time period.
        //
        //   The east in the past was referring to Persia and Cyrus was called by name back then.
        //   The east in the present day meaning is referring to the far east which could mean any of the far east countries.
        //   God narrowed the country by specifying Ravenous Bird or Bird of Prey
        
        //   There is currently one rare Bird of Prey of the East.
        //   And this Bird of Prey is only found in one country. The Philippines.
        //   https://en.wikipedia.org/wiki/Philippine_eagle
        //     The Philippine eagle was officially declared the national bird of the Philippines 
        //     on July 4, 1995, by President Fidel V. Ramos under Proclamation No. 615, 
        //     series of 1995. Due to the eagle's size and rarity, it is also a coveted species 
        //     for birdwatchers.
        //
        //   Bird of Prey
        //   https://www.youtube.com/watch?v=onvsjQUjTIc&t=2590s
        //
        //   God was using that verse to show that the bloodlines for the Bird of Prey is derived from
        //   a specific place; and that man from that same verse will exist after the 1995 national bird 
        //   declaration for that specific country.
        //   
        //   My parents are both from the Philippines and migrated to Guam 
        //   (a territory of the U.S.), where my siblings and I were born. 
        //
        //   I was born and raised in the U.S. and lived there for 45 years until I started to decipher parts of
        //   Revelation and Daniel.
        //
        //   Revelation 18:4  And I heard another voice from heaven, saying, Come out of her, 
        //   my people, that ye be not partakers of her sins, and that ye receive not of her plagues. 
        //
        //   I fled the U.S. in 2022 due to what I deciphered in Revelation.
        //   These were the last photos I took while I was in the U.S. in 2022
        //   https://github.com/rsanluis/esword-cli/blob/main/images/my_signature/left_babylon_in_2022/last_photos_taken_in_2022a.jpg
        //   https://github.com/rsanluis/esword-cli/blob/main/images/my_signature/left_babylon_in_2022/last_photos_taken_in_2022b.jpg
        //
        //   Isaiah 46:11 - Calling a ravenous bird from the east, the man that executeth my counsel 
        //   from a far country
        //
        //   I'm now doing God's bidding from a far country, and he's using me as an instrument 
        //   to bring about his plan and timeline for humanity.
        //
        // Isaiah 43:1  But now thus saith the LORD that created thee, O Jacob, and he that
        //     formed thee, O Israel, Fear not: for I have redeemed thee,
        //     I have called thee by thy name; thou art mine.
       
        // Just like how I called out God's name (I AM times 3) and his number
        // (23 times 3 = 69) he did the same with my name and number.
        // (See confirmatory tests:
        //   DerivedOrCalculatedVerses_23_69_Test.testDerivedMatch_23_69_Test &
        //   WordMatchesTest.testWordMatchesBible_23_Matches_Test
        // ) 
        //

        String name = "Roland Resurreccion San Luis";
        // https://www.gematrix.org/?word=Roland+Resurreccion+San+Luis
        int hebrewGematriaValue = BibleUtils.getHebrewGematriaValue(name);
        log.info("hebrew gematria value for {}: {}", name, hebrewGematriaValue);
        assertTrue(hebrewGematriaValue == 1290);

        // 1290, as this is the number of God's prophetic timeline.
        // 1290 / 30 = 43   (4 + 3) = 7  # for God
        // 1260 / 30 = 42   (4 + 2) = 6  # for Man

        // Yes, that man, that ravenous bird that executes my God's advice from a far country is me.
        // Roland Resurreccion San Luis (equals 1290 in Gematria)
        // 
        // Olan is a childhood nickname I had while growing up and is never used while living in the U.S.
        // I always hear that name again when I visit my parents in the Philippines.
        //
        // My mom derived that name by dropping the first and last letters of my first name. 
        // She would usually repeat that name twice like a lot of names in the Philippines.
        //
        // God also knows my nickname since he's an all knowing God
        // https://github.com/rsanluis/esword-cli/blob/main/images/my_signature/a_new_prophet_like_moses/a_new_prophet_like_moses.png
    }
    
    /* 
     * Further expanding the Biblical code found in the Bible, is the
     * command that God gave me:
     * - To SPEAK of the truth that represents the Word of God
     * - To SPEAK of the timeline that God has decreed for humanity
     * - To SPEAK of the plan that God has for everyone
     */
    @Test
    void testTheCommandThatGodGaveMe() {
       // See validating test: WordMatchesTest.testWordMatchesBible_CommandGivenFromBibleBasedOnFirst3DigitsOfMyBday
       //   returns the command to: SPEAK
    }

    @Test
    void testTheDefinitionThatGodLabeledMe() {
        // See validating test: 
        //   WordMatchesTest.testWordMatchesBible_LabelGivenFromBibleBasedOnFirst3DigitsOfMyBdayReversed
        //
        //   returns 2 values
        //     1) Twenty
        //     2) Prophet
        //
        // If we take 2520 and divide by 20, we get 126
        // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/126.html
        // Appointed in conjunction with God's prophetic clock of 2520 corresponds to
        //   appointed time.
        //
        // https://github.com/rsanluis/esword-cli/blob/main/images/numbers_in_bible/126/appointed_time_126.png
        //
        // Hebrews 9:27, KJV
        //   And as it is appointed unto men once to die, but after this the judgment.
        // 
        // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/20.html
        //
        // The number 20 conveys a meaning of a complete or perfect waiting period.
        // https://github.com/rsanluis/esword-cli/blob/main/images/my_signature/20/20_perfect_waiting_period.png
        //
        // https://github.com/rsanluis/esword-cli/blob/main/images/numbers_in_bible/126/appointed_time_chart_126_of_20.png
        // Chart generated using https://www.meta-chart.com/
        //
        // Ezekiel 33:6  But if the watchman see the sword come, and blow not the trumpet,
        // and the people be not warned; if the sword come, and take any person from 
        // among them, he is taken away in his iniquity; but his blood will I require 
        // at the watchman's hand.
        //
        // Luke 4:24  And he said, Verily I say unto you, No prophet is accepted in his own country. 
        // John 4:44  For Jesus himself testified, that a prophet hath no honour in his own country.
        //
    }

    // James 1:17 KJV - Every good gift and every perfect gift is from above
    // James 1:17 ERV - Everything good comes from God
    // https://github.com/rsanluis/esword-cli/blob/main/images/my_signature/everything_good_comes_from_god.png

    @Test
    void testTheReasonsForCreatingTheseTests() {
        // 1 Thessalonians 5:21
        //   Prove G1381 all things; hold fast G2722 that which is good.
        //     G1381 - to test (literally or figuratively); to discern
        //     G2722 - to hold down (fast); keep (in memory), retain, withold
    }
}
