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
public class SearchDAOImpl_200_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    /*
     * 200 is the ancient Hebrew code for Reysh that signifies the head person or
     * Prince.
     * https://letterpile.com/religion/Berisheet-Our-New-Beginning
     * 
     * All possible uses of H3519 in the entire KJV+ Bible:
     * {glory,glorious,gloriously,honour,honourable}
     */
    @Test
    void testSearchByKeyword_H3519_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("h3519", "OldTestament");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 189);
        assertTrue(matches == 200);
    }
}
