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
public class SearchDAOImpl_30_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_End_AndBookIDs_27_66() {
        // Search both Daniel and Revelation
        List<Integer> bookIDList = new ArrayList<>();
        bookIDList.add(27);
        bookIDList.add(66);
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndBookIDs("end", bookIDList);
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 27);
        assertTrue(matches == 30);
    }
}
