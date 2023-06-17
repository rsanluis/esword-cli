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
public class SearchDAOImpl_10_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
        H5943
        עִלַּי
        ‛illay
        il-lah'ee
        (Chaldee); corresponding to H5942; supreme (that is, God): - (most) high.
        Total KJV occurrences: 10
     */
    @Test
    void testSearchByKeyword_H5943_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H5943", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 10);
        assertTrue(matches == 10);
    }

    @Test
    void testSearchByKeyword_Revelation_AndContext_Bible() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("revelation", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 10);
        assertTrue(matches == 10);
    }
}
