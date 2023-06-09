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
public class SearchDAOImpl_42_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
     * G5056
     * τέλος
     * telos
     * tel'-os
     * From a primary word τέλλω tellō (to set out for a definite point or goal);
     * properly the point aimed at as a limit, that is,
     * (by implication) the conclusion of an act or state (termination [literally,
     * figuratively or indefinitely], result [immediate,
     * ultimate or prophetic], purpose); specifically an impost or levy (as paid): -
     * + continual, custom, end (-ing), finally, uttermost.
     * Compare G5411.
     * Total KJV occurrences: 42
     */
    @Test
    void testSearchByKeyword_G5056_AndContext_NewTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("G5056", "NewTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 41);
        assertTrue(matches == 42);
    }

    /*
     * G5064
     * τέσσαρες, τέσσαρα
     * tessares    tessara
     * tes'-sar-es, tes'-sar-ah
     * Neuter and a plural number; four: - four.
     * Total KJV occurrences: 42
     */
    @Test
    void testSearchByKeyword_G5064_AndContext_NewTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("G5064", "NewTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 35);
        assertTrue(matches == 42);
    }
}
