package com.codified.esword.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.Bible;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class WordOccurrencesTest {
    @Autowired
    BibleDAO bibleDAO;

    @Test
    public void testWordOccurrencesTest() {
        List<Bible> bibleList = bibleDAO.findAll();
        int o=0;
        for (int i=0; i < 31102; i++) {
            String verse = bibleList.get(i).getScripture().toLowerCase();
            verse = StringUtils.replace(verse, "<num>", " ");
            verse = StringUtils.replace(verse, "</num>", " ");
            verse = StringUtils.replace(verse, "<sup>", " ");
            verse = StringUtils.replace(verse, "</sup>", " ");
            verse = StringUtils.replace(verse, "<i>", " ");
            verse = StringUtils.replace(verse, "</i>", " ");
            verse = StringUtils.replace(verse, "<b>", " ");
            verse = StringUtils.replace(verse, "</b>", " ");
            verse = StringUtils.replace(verse, "<red>", " ");
            verse = StringUtils.replace(verse, "</red>", " ");
            verse = StringUtils.replace(verse, "<blu>", " ");
            verse = StringUtils.replace(verse, "</blu>", " ");
            verse = StringUtils.replace(verse, "(", " ");
            verse = StringUtils.replace(verse, ")", " ");
            verse = StringUtils.replace(verse, ":", " ");
            verse = StringUtils.replace(verse, ";", " ");
            verse = StringUtils.replace(verse, ".", " ");
            verse = StringUtils.replace(verse, ",", " ");
            verse = StringUtils.replace(verse, "!", " ");
            verse = StringUtils.replace(verse, "?", " ");
            verse = StringUtils.replace(verse, "--", " ");
            String[] toks = verse.split("\\s+");
            for (int j=0; j<toks.length; j++) {
              String tok = toks[j].trim();
              if (tok.length()==0) {
                continue;
              }
              boolean isAlphaNumeric = true;
              for (int k=0; k<tok.length(); k++) {
                Character ch = tok.charAt(k);
                if (!Character.isAlphabetic(ch) && !Character.isDigit(ch) && ch!='\'' &&  ch!='-') {
                    isAlphaNumeric = false;
                    break;
                }
              }
              if (isAlphaNumeric) {
                  // do work here
                  o++;
              }
            }   
        }
        log.info("o: {}",o);
    }
}
