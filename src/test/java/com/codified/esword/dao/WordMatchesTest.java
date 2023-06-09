package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;
import static com.codified.esword.constants.BibleConstants.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.codified.esword.model.Bible;
import com.codified.esword.model.WordMatches;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class WordMatchesTest {
  @Autowired
  BibleDAO bibleDAO;

  @Autowired
  WordMatchesBibleDAO wordMatchesBibleDAO;

  @Autowired
  WordMatchesDanDAO wordMatchesDanDAO;

  @Autowired
  WordMatchesRevDAO wordMatchesRevDAO;

  @Autowired
  WordMatchesDanRevDAO wordMatchesDanRevDAO;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  public void testWordMatchesBible_11_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(96);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 11);
  }

  @Test
  public void testWordMatchesBible_23_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(69);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 23);
  }

  @Test
  public void testWordMatchesBible_26_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByWord("god's");
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    assertTrue(wordMatchesList.get(0).getMatches() == 26);
  }

  @Test
  public void testWordMatchesBible_42_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(35);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 42);
  }

  @Test
  public void testWordMatchesBible_69_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(42);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 69);
  }

  @Test
  public void testWordMatchesBible_105_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByWord("prince");
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    assertTrue(wordMatchesList.get(0).getMatches() == 102);
    wordMatchesList = wordMatchesBibleDAO.getWordMatchesByWord("prince's");
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    assertTrue(wordMatchesList.get(0).getMatches() == 3);
  }

  @Test
  public void testWordMatchesBible_555_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(555);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    assertTrue(wordMatchesList.get(0).getWord().equals("christ"));
  }

  /*
   * https://www.youtube.com/watch?v=DQIabITex8w
   * Biblical Number #4444 in the Bible – Meaning and Symbolism
   */
  @Test
  public void testWordMatchesBible_4444_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByWord("god");
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    assertTrue(wordMatchesList.get(0).getMatches() == 4444);
  }

  /*
   * https://livingwordin3d.com/discovery/2017/02/27/hebrew-word-study-the-number-300-sheen/
   * 
   * The Letter Sheen is also a Number – 300
   * 300 the Unique Signature of God
   * - The Number 300 magnifies the Number 3
   * - A Divinely Appointed Period of Time – Election
   * - Number Connected to the “Children of Promise”
   * - Supernatural Victory Over Enemies Including Death
   * - Number connected with The Death, Burial, and Resurrection of Messiah
   * - Signifies final Blood Sacrifice Made by the Perfect Lamb of God.
   * 
   * The number 3 is the first of four sacred numbers and it means DIVINE PERFECTION.
   * 
   * 3 = Divine Perfection
   * 7 = Divine Completion
   * 10 = Ordinal Perfection
   * 12 = Governmental Perfection 
   * 
   * 300 divided by Divine  Perfection  3                = 100
   * 300 divided by Ordinal Perfection 10                =  30
   * 100 divided by Ordinal Perfection 10                =  10
   * God's Perfect Clock Ends at 10 + 10 + 10            =  30
   * 10/3 = (3 and 1/3) = 3 * (3 and 1/3)                =  10
   * Ordinal Perfection divided by Divine Perfection * 3 =  10
   * 
   * The end will happen on the 30th day of the 10th month of the appointed year (2030)
   * This will be date of the 2nd coming of our Lord and Savior, Jesus Christ
   */
  @Test
  public void testWordMatchesDanRev_30_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesDanRevDAO.getWordMatchesByMatches(30);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == NUMBER_GOVERNMENTAL_PERFECTION_12);
    // The combined book of matches for Daniel & Revelation yields 12 words that have 30 matches
    //
    // 1.  h3605    whole,one,all,every,open
    // 2.           end 
    // 3.           ye 
    // 4.  h413     unto,to,in,at,for,into
    // 5.           give
    // 6.           interpretation
    // 7.  h6032    answered
    // 8.  h2370    see,seen,sawest
    // 9.           book
    // 10. g4160    did,make,forth,causeth,do,doest,doeth,forth
    // 11. g2400    behold,lo
    // 12. g5064    four
    //
    // Behold, ye sawest book answered.
    // Do give interpretation to all four end.
    //
    // Behold, ye sawest book answered.
    // Do give end interpretation to all four.
    //
    // Behold, you saw (the) book answered. (inserting 'The')
    // Do give (the) end interpretation to all four (winds,corners,parts). (as in Matthew 24:31)
  }

  // Define Order(0) to force the check of DB population before running any word
  // match tests
  @Test
  @Order(0)
  public void testWordMatchesPopulateDBs() {

    String tableName = "WordMatchesDan";
    List<Bible> bibleList = bibleDAO.findByBookId(27);
    Integer rowSize = jdbcTemplate.queryForObject("select count(*) from " + tableName + "", Integer.class);
    assertNotNull(rowSize);
    if (rowSize != 2383) {
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    } else {
      log.info("Table " + tableName + " is already populated");
    }

    tableName = "WordMatchesRev";
    rowSize = jdbcTemplate.queryForObject("select count(*) from " + tableName + "", Integer.class);
    assertNotNull(rowSize);
    if (rowSize != 2258) {
      bibleList = bibleDAO.findByBookId(66);
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    } else {
      log.info("Table " + tableName + " is already populated");
    }

    tableName = "WordMatchesDanRev";
    rowSize = jdbcTemplate.queryForObject("select count(*) from " + tableName + "", Integer.class);
    assertNotNull(rowSize);
    if (rowSize != 4036) {
      bibleList = Stream.concat(bibleDAO.findByBookId(27).stream(), bibleDAO.findByBookId(66).stream()).toList();
      log.info("Populating table: {}", tableName);
      populateTable(tableName, bibleList);
    } else {
      log.info("Table " + tableName + " is already populated");
    }

    tableName = "WordMatchesBible";
    rowSize = jdbcTemplate.queryForObject("select count(*) from " + tableName + "", Integer.class);
    assertNotNull(rowSize);
    if (rowSize != 26971) {
      bibleList = bibleDAO.findAll();
      log.info("Populating table: {}", tableName);
      log.info("Warning: This may take up to 20-30 minutes");
      populateTable(tableName, bibleList);
    } else {
      log.info("Table " + tableName + " is already populated");
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
