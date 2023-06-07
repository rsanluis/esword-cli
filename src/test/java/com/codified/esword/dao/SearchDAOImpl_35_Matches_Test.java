package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.SearchResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SearchDAOImpl_35_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_H7093_AndContext_MajorProphets() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H7093", "MajorProphets");
        int verses  = 0;
        int matches = 0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 30);
        assertTrue(matches == 35);
    }

    @Test
    void testSearchByKeyword_Authority_AndContext_NewTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("authority", "NewTestament");
        int verses  = 0;
        int matches = 0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 32);
        assertTrue(matches == 35);
    }

    @Test
    void testSearchByKeyword_Flood_AndContext_PaulsLetters() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("flood", "OldTestament");
        int verses  = 0;
        int matches = 0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 32);
        assertTrue(matches == 35);
    }

    @Test
    void testSearchByKeyword_Blood_AndContext_PaulsLetters() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("blood", "PaulsLetters");
        int verses  = 0;
        int matches = 0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 33);
        assertTrue(matches == 35);
    }
}
