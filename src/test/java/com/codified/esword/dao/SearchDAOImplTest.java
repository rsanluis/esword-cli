package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SearchDAOImplTest {

    @Autowired
    SearchDAO searchDAO;

    @Test // TODO: change into a different test
    void testSearchByKeyword_Blood_AndBookIDs_5_66() { 
        List<Integer> bookIDList = new ArrayList<>();
        bookIDList.add(5);
        bookIDList.add(66);
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndBookIDs("blood", bookIDList);
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 33);
        assertTrue(matches == 41);
    }
}
