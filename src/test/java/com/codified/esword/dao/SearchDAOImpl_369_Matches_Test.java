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
public class SearchDAOImpl_369_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
     * Rev_14:8
     * And there followed another angel, saying, Babylon is fallen, is fallen, that
     * great city, because she made all nations
     * **drink** of the wine of the wrath of her fornication.
     */
    @Test
    void testSearchByKeyword_Drink_AndContext_Bible() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("drink", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 327);
        assertTrue(matches == 369);
    }

    // Notice that 3-6-9 becomes a full circle with 3 slices of 3's
    // 2520 divided by 420 equals 6
    @Test
    void testSearchByKeyword_Flesh_AndContext_Bible() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("flesh", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 369);
        assertTrue(matches == 420);
    }

    


}
