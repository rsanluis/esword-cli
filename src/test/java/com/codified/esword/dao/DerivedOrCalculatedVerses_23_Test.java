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
public class DerivedOrCalculatedVerses_23_Test {

    @Autowired
    SearchDAO searchDAO;

    @Test
    void testDerivedMatch_23_69_Test() {
        List<SearchResult> resultsList = searchDAO.searchByBookChapterAndVerse("Exodus", 3, 14);
        assertTrue(resultsList.size()==1);
        String scripture = resultsList.get(0).getScripture();
        log.info("scripture: {}", scripture);
        int matches = StringUtils.countMatches(scripture, "I AM");
        // Notice that I AM is repeated exactly 3 times for this 1 verse
        assertTrue(matches == 3);
        int simpleGematriaValue = BibleUtils.getSimpleGematriaValue("I AM");
        assertTrue(simpleGematriaValue == 23);
        assertTrue(3 * simpleGematriaValue == 69);
        // Compare to testWordMatchesBible_23_Matches_Test
    }
}
