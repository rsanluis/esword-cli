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
public class SearchDAOImpl_42_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
    G5056
    τέλος
    telos
    tel'-os
    From a primary word τέλλω tellō (to set out for a definite point or goal); properly the point aimed at as a limit, that is, 
    (by implication) the conclusion of an act or state (termination [literally, figuratively or indefinitely], result [immediate, 
    ultimate or prophetic], purpose); specifically an impost or levy (as paid): - + continual, custom, end (-ing), finally, uttermost. 
    Compare G5411.
    
    Total KJV occurrences: 42
    */
    @Test
    void testSearchByKeyword_G5056_AndContext_NewTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("G5056", "NewTestament");
        int verses  = 0;
        int matches = 0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 41);
        assertTrue(matches == 42);
    }
}

