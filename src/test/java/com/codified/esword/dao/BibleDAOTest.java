package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.Bible;
import com.codified.esword.model.ScriptureId;

@SpringBootTest
public class BibleDAOTest {

    @Autowired
    BibleDAO bibleDAO;
    
    @Test
    void testCount() {
        assertTrue(bibleDAO.count()==31102);
    }

    @Test
    void testGetByBookId() {
        List<Bible> bibleList = bibleDAO.getByBookId(31);
        assertTrue(bibleList.size()==21);
    }

    @Test
    void testGetByBookIdAndChapterId() {
        List<Bible> bibleList = bibleDAO.getByBookIdAndChapterId(31,1);
        assertTrue(bibleList.size()==21);
    }

    @Test
    void testGetByScriptureId() {
        Bible bible = bibleDAO.getByScriptureId(new ScriptureId(1,1,1));
        String verse = bible.getScripture();
        String expectedVerse = "In the beginning<num>H7225</num> God<num>H430</num> created<num>H1254</num> <sup>(</sup><num>H853</num><sup>)</sup> the heaven<num>H8064</num> and the earth.<num>H776</num>";
        assertTrue(expectedVerse.equals(verse));
    }
}
