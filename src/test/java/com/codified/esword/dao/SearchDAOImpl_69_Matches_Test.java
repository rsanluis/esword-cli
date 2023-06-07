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
public class SearchDAOImpl_69_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_Obey_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("obey", "Bible");
        int verses  = 0;
        int matches = 0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 66);
        assertTrue(matches == 69);
    }
}

