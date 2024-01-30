package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SearchDAOImpl_69_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_Obey_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("obey", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 66);
        assertTrue(matches == 69);
    }

    // G5140
    // τρεῖς, τρία
    // treis    tria
    // trice, tree'-ah
    // A primary (plural) number; “three”: - three.
    // Total KJV occurrences: 69
    @Test
    void testSearchByKeyword_G5140_AndContext_Bible() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("g5140", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 60);
        assertTrue(matches == 69);
        // 69 divided by 3 = 23 which stands for "I AM"
        // 60 divided by 3 = 20 which stands for the "waiting period"
        // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/20.html
        // 2520 divided by 20 = 126 
        // The English word "appointed" is listed 126 times in 126 King James Bible verses.
        // https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/126.html
        // "Appointed" time
    }
}
