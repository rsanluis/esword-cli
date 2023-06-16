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
public class SearchDAOImpl_60_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
        H2555
        חָמָס
        châmâs
        khaw-mawce'
        From H2554; violence; by implication wrong; by metonymy unjust gain: - cruel (-ty), damage, false, injustice, X oppressor, unrighteous, violence (against, done), violent (dealing), wrong.
        Total KJV occurrences: 60
     */
    @Test
    void testSearchByKeyword_H2555_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H2555", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 59);
        assertTrue(matches == 60);
        // Uses of h2555: {violence,wrong,cruelty,unrighteous,false,violent,injustice,cruel,oppressor,damage}
    }
}
