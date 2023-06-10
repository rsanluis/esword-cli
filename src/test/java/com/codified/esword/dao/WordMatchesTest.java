package com.codified.esword.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.codified.esword.mapper.WordMatchesRowMapper;
import com.codified.esword.model.Bible;
import com.codified.esword.model.SearchResult;
import com.codified.esword.model.WordMatches;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class WordMatchesTest {
  @Autowired
  BibleDAO bibleDAO;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  public void testWordMatchesTest() {

    String tableName = "WordMatchesDan";
    List<Bible> bibleList = bibleDAO.findByBookId(27);
    List<WordMatches> wordMatchesList = jdbcTemplate.query("select * from " + tableName + "",
        new WordMatchesRowMapper());
    if (wordMatchesList.size() != 2383) {
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    }

    tableName = "WordMatchesRev";
    wordMatchesList = jdbcTemplate.query("select * from " + tableName + "",
        new WordMatchesRowMapper());
    if (wordMatchesList.size() != 2258) {
      bibleList = bibleDAO.findByBookId(66);
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    }

    tableName = "WordMatchesDanRev";
    wordMatchesList = jdbcTemplate.query("select * from " + tableName + "",
        new WordMatchesRowMapper());
    if (wordMatchesList.size() != 4036) {
      bibleList = Stream.concat(bibleDAO.findByBookId(27).stream(), bibleDAO.findByBookId(66).stream()).toList();
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    }

    tableName = "WordMatchesBible";
    wordMatchesList = jdbcTemplate.query("select * from " + tableName + "",
        new WordMatchesRowMapper());
    if (wordMatchesList.size() != 26971) {
      bibleList = bibleDAO.findAll();
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    }
  }

  private void populateTable(String tableName, List<Bible> bibleList) {
    int wordCount = 0;
    for (int i = 0; i < bibleList.size(); i++) {
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
      for (int j = 0; j < toks.length; j++) {
        String tok = toks[j].trim();
        if (tok.length() == 0) {
          continue;
        }
        boolean isAlphaNumeric = true;
        for (int k = 0; k < tok.length(); k++) {
          Character ch = tok.charAt(k);
          if (!Character.isAlphabetic(ch) && !Character.isDigit(ch) && ch != '\'' && ch != '-') {
            isAlphaNumeric = false;
            break;
          }
        }
        if (isAlphaNumeric) {
          try {
            jdbcTemplate.update("insert into " + tableName + " (word,matches) values (?,1)", new Object[] { tok });
          } catch (UncategorizedSQLException ex) {
            WordMatches word = jdbcTemplate.queryForObject("select * from " + tableName + " where word = ?",
                new RowMapper<WordMatches>() {
                  @Override
                  public WordMatches mapRow(ResultSet rs, int rownumber) throws SQLException {
                    WordMatches w = new WordMatches();
                    w.setId(rs.getInt(1));
                    w.setWord(rs.getString(2));
                    w.setMatches(rs.getInt(3));
                    return w;
                  }
                }, tok);
            if (word != null) {
              jdbcTemplate.update("update " + tableName + " set matches = ? where word = ?", word.getMatches() + 1,
                  word.getWord());
            }
          }
          wordCount++;
        }
      }
    }
    log.info("word count: {}", wordCount);
  }
}
