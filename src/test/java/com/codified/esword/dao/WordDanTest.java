package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.codified.esword.model.Bible;
import com.codified.esword.model.WordDan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class WordDanTest {
    @Autowired
    BibleDAO bibleDAO;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testWordOccurrencesTest() {
        List<Bible> bibleList = bibleDAO.findByBookId(27);
        //List<Bible> bibleRevList = bibleDAO.findByBookId(66);
        //List<Bible> bibleList = Stream.concat(bibleDanList.stream(), bibleRevList.stream()).toList();
      
        int o=0;
        for (int i=0; i < bibleList.size(); i++) {
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
                  String sql = "insert into WordDan (word,matches) values (?,1)";
                  try {
                    jdbcTemplate.update(sql, new Object[] { tok });
                  } catch (UncategorizedSQLException ex) {
                    //jdbcTemplate.queryForObject("select * from word where word = ?", new Object[] { tok }, new Ro);


                      WordDan word = jdbcTemplate.queryForObject("select * from WordDan where word = ?", new RowMapper<WordDan>(){  
                          @Override  
                          public WordDan mapRow(ResultSet rs, int rownumber) throws SQLException {  
                              WordDan w=new WordDan();  
                              w.setId(rs.getInt(1));  
                              w.setWord(rs.getString(2));  
                              w.setMatches(rs.getInt(3));  
                              return w;  
                          }  
                          },tok);
                      if (word!=null) {
                        jdbcTemplate.update("update WordDan set matches = ? where word = ?", word.getMatches()+1, word.getWord());
                      }
                  }
                  o++;
              }
            }   
        }
        log.info("o: {}",o);
    }
}
