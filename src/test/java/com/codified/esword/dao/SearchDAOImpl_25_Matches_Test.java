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

    /*
     * H1290
     * בֶּרֶךְ
     * berek
     * beh'-rek
     * From H1288; a knee: - knee.
     * Total KJV occurrences: 25
     * 
     * H1288 - A primitive root; to kneel; by implication to ***bless*** God (as an act of adoration)
     * 
     * This is exactly what I did to derive the timeline:
     * 1) Fear the Lord
     *   Proverbs 9:10  The fear of the LORD is the beginning of wisdom: 
     *   and the knowledge of the holy is understanding. 
     * 2) Pray for wisdom
     *   James 1:5  If any of you lack wisdom, let him ask of God, that giveth to all men liberally, 
     *   and upbraideth not; and it shall be given him. 
     * 3) Bless God by praying on your knees
     *   1Kings 8:54  And it was so, that when Solomon had made an end of praying all this prayer and 
     *   supplication unto the LORD, he arose from before the altar of the LORD, from kneeling on 
     *   his knees with his hands spread up to heaven.
     */
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
