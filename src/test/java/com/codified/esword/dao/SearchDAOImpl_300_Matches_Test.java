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
public class SearchDAOImpl_300_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
     * https://web.archive.org/web/20230620142124/https://livingwordin3d.com/discovery/2017/02/27/hebrew-word-study-the-number-300-sheen/
     * In the New Testament, the words (me or I) are used interchangeably for g3165
     */
    @Test
    void testSearchByKeyword_G3165_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("g3165", "NewTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 275);
        assertTrue(matches == 300);
    }
}
