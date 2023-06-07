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
public class SearchDAOImpl_86_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_H3925_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H3925", "OldTestament");
        int verses  = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 80);
        assertTrue(matches == 86);
    }

    @Test
    void testSearchByKeyword_Vanity_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("vanity", "Bible");
        int verses  = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 79);
        assertTrue(matches == 86);
    }

    @Test
    void testSearchByKeyword_G2540_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("G2540", "NewTestament");
        int verses  = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 81);
        assertTrue(matches == 86);
    }

    @Test
    void testSearchByKeyword_H7891_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H7891", "OldTestament");
        int verses  = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 78);
        assertTrue(matches == 86);
    }

    @Test
    void testSearchByKeyword_Vision_Visions_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("vision", "OldTestament");
        int verses  = 0;
        int matchesForVision  = 0;
        int matchesForVisions = 0;
        matchesForVision += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matchesForVision);
        assertTrue(verses == 58);
        assertTrue(matchesForVision == 64);
        verses  = 0;
        matchesForVisions = 0;
        resultsList = searchDAO.searchByKeywordAndContext("visions", "OldTestament");
        matchesForVisions += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matchesForVisions);
        assertTrue(verses == 22);
        assertTrue(matchesForVisions == 22);
        // 64 + 22 = 86 total matches for vision/visons in the Old Testament
        assertTrue((matchesForVision + matchesForVisions) == 86);
    }
}

