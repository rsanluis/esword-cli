package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SearchDAOImpl_69_Matches_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testSearchByKeyword_Obey_AndContext_OldTestament() {
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext("obey", "Bible");
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        log.info("verses:  {}", verses);
        log.info("matches: {}", matches);
        assertTrue(verses == 66);
        assertTrue(matches == 69);
    }

    @Test
    void testDerivedMatch_69_Test() {
        List<SearchResult> resultsList = searchDAO.searchByBookChapterAndVerse("Exodus", 3, 14);
        assertTrue(resultsList.size()==1);
        String scripture = resultsList.get(0).getScripture();
        log.info("scripture: {}", scripture);
        int matches = StringUtils.countMatches(scripture, "I AM");
        // Notice that I AM is repeated exactly 3 times for this 1 verse and is equivalent to the value
        // of PI; prophesying what is to become at full circle
        assertTrue(matches == 3);
        int simpleGematriaValueForIam = 23;
        assertTrue(3 * simpleGematriaValueForIam == 69);
        // Compare to testWordMatchesBible_23_Matches_Test
    }
}
