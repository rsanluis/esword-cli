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
public class SearchDAOImpl_111_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
     * There are 111 matches of 'horses' in the Bible.  Horses are frequently mentioned in the Bible
     * within the context of war.
     */
    @Test
    void testSearchByKeyword_Horses_AndContext_Bible() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("horses", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 105);
        assertTrue(matches == 111);
    }
}
