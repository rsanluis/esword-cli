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
public class SearchDAOImpl_06_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
        H8431
        תּוֹחֶלֶת
        tôcheleth
        to-kheh'-leth
        From H3176; expectation: - hope.
        Total KJV occurrences: 6
        Psa 39:7  And now, H6258 Lord, H136 what H4100 wait H6960 I for? my hope H8431 is in thee. 
     */
    @Test
    void testSearchByKeyword_H8431_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("H8431", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 6);
        assertTrue(matches == 6);
    }
}
