package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
     * Isa 43:1  But now thus saith the LORD that created thee, O Jacob, and he that
     * formed thee, O Israel, Fear not: for I have redeemed thee,
     * I have called thee by thy name; thou art mine. 
     * 
     * Just like how I called out God's name (I AM times 3) and his number 
     * (23 times 3 = 69), he did the same with my name and number.
     */
    @Test
    void testDerivedMatch_1290_Test() {
        String name = "Roland Resurreccion San Luis";
        // https://www.gematrix.org/?word=Roland+Resurreccion+San+Luis
        int hebrewGematriaValue = BibleUtils.getHebrewGematriaValue(name);
        log.info("hebrew gematria value for {}: {}", name, hebrewGematriaValue);
        assertTrue(hebrewGematriaValue == 1290);
    }

    @Test
    void testIsaiah46_9_11() {
        //
        // This is a true story worth re-telling, otherwise it will remain forever between myself and God
        //
        // Within the Year(s):Month(s) away from my birthday 05/13/1976
        //
        // 46th year:9th month - At this time, I had already derived of the 11/01/2023 date for the 
        //         destruction of Babylon and 12/06/2023 for being the start of tribulation.
        //         You can verify the timestamps of the timeline I created based on Daniel & Revelation:
        //         https://time.graphics/line/566988
        //         I fasted and prayed for 10 days (03/01/2023-03/10/2023) with incense; asking God
        //         "Should I show this info to his people?"  I told him, "They won't ever believe me"
        //
        // 46th year:10th month - He showed me other verses that instructed me to utter this info to his people, 
        //         no matter if they would like to hear me or not.
        //         Isaiah 48:20 Go ye forth of Babylon, flee ye from the Chaldeans, with a voice of singing declare ye, 
        //         tell this, utter it even to the end of the earth; say ye, The LORD hath redeemed his servant Jacob.
        //
        //         I followed his advice (counsel) and did the video,
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
        // Isaiah 46:11 - This same verse holds different meanings for each time period.
        //         The east in the past was Persia and Cyrus was called by name.
        //         The east in the present day meaning is the far east which could mean any of the far east countries.
        //         God narrowed the country by specifying ravenous bird or bird of prey.
        //         There is currently one rare bird of the east and that is only found in the country of the Philippines.
        //         https://en.wikipedia.org/wiki/Philippine_eagle
        //         God was using that verse to show that my bloodlines are Filipino, althouth I was born & raised in the U.S.
        //         I fled the U.S. in 2022 due to what I know after deciphering the verses in Revelation.
        //         As I'm calling him by his number and name, he is also calling me via number:
        //         1290, as this is the number of God's prophetic timeline.
        //         1290 / 30 = 43   (4+3) = 7 # for God
        //         1260 / 30 = 42   (4+2) = 6 # for Man
        //         I'm now doing God's bidding from a far country, and he's using me as an instrument to bring about 
        //         his plan and timeline for humanity.
    }
}
