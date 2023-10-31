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

  /*
   * Exodus 3:14  And God said unto Moses, I AM THAT I AM: and he said, 
   * Thus shalt thou say unto the children of Israel, I AM hath sent me unto you. 
   * https://www.gematrix.org/?word=Pi
   * Notice how Pi aligns with the chapter & verse # 3:14
   * 69 divided by 3 parts = 23
   * The KJV+ Bible confirms this with 23 words total with 69 matches
   * esword wordmatch -c Bible -m 69
   * 23 words in total with 69 occurrences/matches
   * https://github.com/rsanluis/esword-cli/blob/main/images/testWordMatchesBible_23_Matches_Test.png
   */
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
   * H2555
   * חָמָס
   * châmâs
   * khaw-mawce'
   * From H2554; violence; by implication wrong; by metonymy unjust gain: - cruel
   * (-ty), damage, false, injustice, X oppressor, unrighteous, violence (against,
   * done), violent (dealing), wrong.
   * Total KJV occurrences: 60
   */
  @Test
  public void testWordMatchesBible_2555_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByWord("h2555");
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    assertTrue(wordMatchesList.get(0).getMatches().equals(60));
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
   * https://livingwordin3d.com/discovery/2017/02/27/hebrew-word-study-the-number-
   * 300-sheen/
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
   * The number 3 is the first of four sacred numbers and it means DIVINE
   * PERFECTION.
   * 
   * 3 = Divine Perfection
   * 7 = Divine Completion
   * 10 = Ordinal Perfection
   * 12 = Governmental Perfection
   * 
   * 300 divided by Divine Perfection 3 = 100
   * 300 divided by Ordinal Perfection 10 = 30
   * 100 divided by Ordinal Perfection 10 = 10
   * God's Perfect Clock Ends at 10 + 10 + 10 = 30
   * 10/3 = (3 and 1/3) = 3 * (3 and 1/3) = 10
   * Ordinal Perfection divided by Divine Perfection * 3 = 10
   * 
   * The end will happen on the 30th day of the 10th month of the appointed year
   * (2030)
   * This will be date of the 2nd coming of our Lord and Savior, Jesus Christ
   */
  @Test
  public void testWordMatchesDanRev_30_Matches_Test() {
    List<WordMatches> wordMatchesList = wordMatchesDanRevDAO.getWordMatchesByMatches(30);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == NUMBER_GOVERNMENTAL_PERFECTION_12);
    // The combined book of matches for Daniel & Revelation yields 12 words that
    // have 30 matches
    //
    // 1. h3605 whole,one,all,every,open
    // 2. end
    // 3. ye
    // 4. h413 unto,to,in,at,for,into
    // 5. give
    // 6. interpretation
    // 7. h6032 answered
    // 8. h2370 see,seen,sawest
    // 9. book
    // 10. g4160 did,make,forth,causeth,do,doest,doeth,forth
    // 11. g2400 behold,lo
    // 12. g5064 four
    //
    // Behold, ye sawest book answered.
    // Do give interpretation to all four end.
    //
    // Behold, ye sawest book answered.
    // Do give end interpretation to all four.
    //
    //   Behold, you saw (the) book answered. (inserting 'The')
    //   Do give (the) end interpretation to all four (winds,corners,parts)
    //     (as in Matthew 24:31)
    //
    //
    //     Behold, you saw the book answered.
    //     Do give the END INTERPRETATION to all four corners.
    //
    //
    // I derived God's command based on the first 3 digits of my birthday, 513
    // which indicates that the Bible is telling us that one who found the end interpretation
    // is the one qualified telling the meaning of the unsealed book of Daniel and Revelation
    //
    // https://reasons.org/explore/publications/articles/fulfilled-prophecy-evidence-for-the-reliability-of-the-bible
    //
    // The acid test for identifying a prophet of God is recorded by Moses in 
    //   Deuteronomy 18:21-22. According to this Bible passage (and others), 
    //   God’s prophets, as distinct from Satan’s spokesmen, are 100 percent accurate
    //   in their predictions. There is no room for error.
    //
    //
    // Deu 18:18  I will raise them up a Prophet from among their brethren, like unto thee, 
    //   and will put my words in his mouth; and he shall speak unto them all that I shall command him. 
    // Deu 18:19  And it shall come to pass, that whosoever will not hearken unto my words which he 
    //   shall speak in my name, I will require it of him. 
    // Deu 18:20  But the prophet, which shall presume to speak a word in my name, which I have not 
    //   commanded him to speak, or that shall speak in the name of other gods, even that prophet shall die. 
    // Deu 18:21  And if thou say in thine heart, How shall we know the word which the LORD hath not 
    //   spoken? 
    // Deu 18:22  When a prophet speaketh in the name of the LORD, if the thing follow not, nor come 
    //   to pass, that is the thing which the LORD hath not spoken, but the prophet hath spoken it 
    //   presumptuously: thou shalt not be afraid of him. 
  }
  @Test
  public void testWordMatchesBible_CommandGivenFromBibleBasedOnFirst3DigitsOfMyBday() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(513);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    String wordMatch = wordMatchesList.get(0).getWord();
    assertTrue(wordMatch.equals("speak"));
    // https://github.com/rsanluis/esword-cli/blob/main/images/testWordMatchesBible_CommandGivenFromBibleBasedOnFirst3DigitsOfMyBday.png
    // Here is the command instructed extracted from the Bible corresponding to my birth date
  }

  // To have the knowledge of reversing my #, you will have to first understand reversing the
  // # of God, which is 35 (El Deah)
  //
  // Genesis 17:1  And when Abram was ninety years old and nine, the LORD appeared to Abram, 
  // and said unto him, I am the Almighty God; walk before me, and be thou perfect. 
  //
  // The key verse to extract is: 
  //   I am the Almighty God
  //
  // This is a Biblical pattern based on the knowledge of COUNTING in the present.
  // When this was written (over 2000 years ago), it indicates a FUTURE method of counting
  // that will be realized in the future.
  //
  // I is equivalent to 1
  //   https://github.com/rsanluis/esword-cli/blob/main/images/nth_root_comparison.png
  //   AM is equivalent to 10 10

  //   as A is unto Alpha
  //   as M is unto Omega

  //   as A is unto The beginning
  //   as M is unto The end

  //   as A is unto The First
  //   as M is unto The Last
  
  //   Almighty God is unto 1
  //
  //   The present method of counting is in binary:
  //   I   A  M   Almighty God  (mighty one)
  //   1  10  10  1             (in binary) = 53 (in decimal)
  //
  //   https://www.biblestudy.org/bibleref/meaning-of-numbers-in-bible/53.html
  //   Fools and the Number 53
  //   Written by King David, Psalm 53 gives us a true definition of a fool! It also reveals the 
  //   real life consequences of humans refusing, despite the overwhelming evidence (Romans 1:19 - 22),
  //   to acknowledge God exists and deserves to be obeyed.
  //   
  //   Revelation 1:8  I am Alpha and Omega, the beginning and the ending, saith the Lord, which is, 
  //   and which was, and which is to come, the Almighty. 
  //
  //   I am Alpha and Omega ... which is to come/become the Almighty
  //   1    10        10                                       1 = 110101 (in binary) = 53 (in decimal)
  //
  //   Genesis 17:1  ... I am the Almighty God; walk before me, and be thou perfect.
  //                     1 10 10      1 = 110101 (in binary) = 53 (in decimal)
  //
  //  
  //   https://www.gematrix.org/?word=i%20am%20he
  //   I am he = 53 in Hebrew Gematria
  //   lamb    = 53 in Hebrew Gematria
  //   

  // Using my birth date: 05/13/76
  // From the above knowledge of reversing God's # of 35, we do the same with the number that 
  //   represents me: 513 (command to speak)
  //   reversing 513, we get 315
  // 
  // esword wordmatch -c Bible -m 315
  // https://github.com/rsanluis/esword-cli/blob/main/images/testWordMatchesBible_LabelGivenFromBibleBasedOnFirst3DigitsOfMyBdayReversed.png
  //
  // H6242
  // עֶשְׂרִים
  // ‛eśrı̂ym
  // es-reem'
  // From H6235; twenty; also (ordinal) twentieth: - [six-] score, twenty (-ieth).
  // Total KJV occurrences: 315
  // 
  //  H5030
  // נָבִיא
  // nâbı̂y'
  // naw-bee'
  // From H5012; a prophet or (generally) inspired man: - prophecy, that prophesy, prophet.
  // Total KJV occurrences: 315
  @Test 
  public void testWordMatchesBible_LabelGivenFromBibleBasedOnFirst3DigitsOfMyBdayReversed() {
    List<WordMatches> wordMatchesList = wordMatchesBibleDAO.getWordMatchesByMatches(315);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 2);
    String wordMatch1 = wordMatchesList.get(0).getWord();
    String wordMatch2 = wordMatchesList.get(1).getWord();
    assertTrue(wordMatch1.equals("h6242"));
    assertTrue(wordMatch2.equals("h5030"));
  }

  // With Daniel and Revelation combined; the year (76 matches) labels me as a messenger of God
  //
  // G32
  // ἄγγελος
  // aggelos
  // ang'-el-os
  // From ἀγγέλλω aggellō (probably derived from G71; compare G34; to bring tidings); a messenger; especially an “angel”; by implication a pastor: - angel, messenger.
  // Total KJV occurrences: 186
  @Test 
  public void testWordMatchesDanRev_LabelGivenFromBibleBasedOnYearOfMyBday() {
    List<WordMatches> wordMatchesList = wordMatchesDanRevDAO.getWordMatchesByMatches(76);
    log.info("wordMatchesList.size: {}", wordMatchesList.size());
    assertTrue(wordMatchesList.size() == 1);
    String wordMatch = wordMatchesList.get(0).getWord();
    assertTrue(wordMatch.equals("g32"));
    // https://github.com/rsanluis/esword-cli/blob/main/images/testWordMatchesDanRev_LabelGivenFromBibleBasedOnYearOfMyBday.png
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
