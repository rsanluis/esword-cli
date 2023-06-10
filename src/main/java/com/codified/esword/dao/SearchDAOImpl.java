package com.codified.esword.dao;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.codified.esword.mapper.SearchResultRowMapper;
import com.codified.esword.model.SearchResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SearchDAOImpl implements SearchDAO {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<SearchResult> searchByKeywordAndContext(String keyword, String context) {
    String sql = "select bible.book,book.title,book.short_title,bible.chapter,bible.verse,highlight(BibleFTS,3,'"
        + MATCH_START_TAG + "','" + MATCH_END_TAG
        + "') scripture from BibleFTS bible, Book book, Context context where " +
        "bible.scripture match :keyword and bible.book >= context.start_id and bible.book <= context.end_id and " +
        "bible.book = book.id and context.context=:context";

    List<SearchResult> searchResultList = jdbcTemplate.query(sql, new SearchResultRowMapper(), keyword, context);
    return searchResultList;
  }

  @Override
  public List<SearchResult> searchByKeywordAndBookIDs(String keyword, List<Integer> bookIDs) {
    String inSQL = bookIDs.stream()
        .map(n -> String.valueOf(n))
        .collect(Collectors.joining(",", "(", ")"));

    String sql = "select bible.book,book.title,book.short_title,bible.chapter,bible.verse,highlight(BibleFTS,3,'"
        + MATCH_START_TAG + "','" + MATCH_END_TAG
        + "') scripture from BibleFTS bible, Book book where bible.scripture match :keyword and bible.book = book.id and book.id in "
        + inSQL;
    List<SearchResult> searchResultList = jdbcTemplate.query(sql, new SearchResultRowMapper(), keyword);

    return searchResultList;
  }
}
