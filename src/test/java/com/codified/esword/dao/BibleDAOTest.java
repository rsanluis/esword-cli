package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertNull;
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
        assertTrue(bibleDAO.count() == 31102);
    }

    @Test
    void testGetByBookId() {
        List<Bible> bibleList = bibleDAO.findByBookId(31);
        assertTrue(bibleList.size() == 21);
    }

    @Test
    void testGetByBookIdAndChapterId() {
        List<Bible> bibleList = bibleDAO.findByBookIdAndChapterId(31, 1);
        assertTrue(bibleList.size() == 21);
    }

    @Test
    void testGetByScriptureId() {
        String expectedVerse = "In the beginning<num>H7225</num> God<num>H430</num> created<num>H1254</num> " +
                "<sup>(</sup><num>H853</num><sup>)</sup> the heaven<num>H8064</num> and the earth.<num>H776</num>";

        Bible bible = bibleDAO.getByScriptureId(new ScriptureId(1, 1, 1));
        String verse = bible.getScripture();
        assertTrue(expectedVerse.equals(verse));
    }

    @Test
    void testGetByScriptureIdNotFound() {
        Bible bible = bibleDAO.getByScriptureId(new ScriptureId(0, 1, 1));
        assertNull(bible);
    }
}
