package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codified.esword.constants.BibleConstants.*;
import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SearchDAOImpl_25_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_H1290_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H1290", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 25);
        assertTrue(matches == NUMBER_GRACE_UPON_GRACE_25);
    }
}
