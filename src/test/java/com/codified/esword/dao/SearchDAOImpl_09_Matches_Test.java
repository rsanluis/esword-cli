package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SearchDAOImpl_09_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_H8086_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H8086", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 9);
        assertTrue(matches == 9);
    }

    /*
        Mat_11:25  At that time Jesus answered and said, I thank thee, O Father, Lord of heaven and earth, 
        because thou hast hid these things from the wise and prudent, and hast revealed them unto babes.

        Luk_10:21  In that hour Jesus rejoiced in spirit, and said, I thank thee, O Father, Lord of heaven 
        and earth, that thou hast hid these things from the wise and prudent, and hast revealed them unto 
        babes: even so, Father; for so it seemed good in thy sight.

        G3516
        νήπιος
        nēpios
        nay'-pee-os
        From an obsolete particle νη ne; implying negation and G2031; not speaking, that is, an infant (minor); 
        figuratively a simple minded person, an immature Christian: - babe, child (+ -ish).
        Total KJV occurrences: 14
     */
    @Test
    void testSearchByKeyword_Babes_AndContext_Bible() {
        // 3-6-9 match
        // 3 matches in Old Testament
        // 6 matches in New Testament
        // 9 matches in Total
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("babes", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 3);
        assertTrue(matches == 3);
        resultsList = searchDAO.searchByKeywordAndContext("babes", "NewTestament");
        verses = 0;
        matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 6);
        assertTrue(matches == 6);
        resultsList = searchDAO.searchByKeywordAndContext("babes", "Bible");
        verses = 0;
        matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 9);
        assertTrue(matches == 9);
    }
}
