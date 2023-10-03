package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codified.esword.constants.BibleConstants.*;

import com.codified.esword.model.Bible;
import com.codified.esword.model.ScriptureId;
import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DerivedOrCalculatedVerses_26_Test {

    @Autowired
    SearchDAO searchDAO;

    @Autowired 
    BibleDAO bibleDAO;

    /*
     * 26 as a representation for the number of God
     * 
     * Isaiah 45:22  Look unto me, and be ye saved, all the ends of the earth: 
     * for I am God, and there is none else. 
     * 
     * https://www.biblegematria.com/pi-and-the-bible.html
     * https://github.com/rsanluis/esword-cli/blob/main/images/testDerivedMatch_26_VerseNumber_18584_Test.png
     */
    @Test
    void testDerivedMatch_26_VerseNumber_18584_Test() {
        int verseNumber = 18584;
        List<Bible> resultsList = bibleDAO.findAll();
        // subtract by 1 since index starts at 0
        Bible verse = resultsList.get(verseNumber - 1);
        ScriptureId scriptureId = verse.getScriptureId();
        log.info(scriptureId.toString());
        assertTrue(scriptureId.getBook()==23);    // Book    23 is Isaiah
        assertTrue(scriptureId.getChapter()==45); // Chapter 45
        assertTrue(scriptureId.getVerse()==22);   // Verse   22
        int valueOfVerseNumber = 1 + 8 + 5 + 8 + 4;
        assertTrue(valueOfVerseNumber == 26);
    }
}
