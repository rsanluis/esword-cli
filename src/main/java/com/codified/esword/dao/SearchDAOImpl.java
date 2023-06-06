package com.codified.esword.dao;

import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.codified.esword.model.SearchResult;

@Service
public class SearchDAOImpl implements SearchDAO {
  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public List<SearchResult> searchByKeyword(String keyword) {
    String sql = "select bible.book,book.title,book.short_title,bible.chapter,bible.verse,highlight(BibleFTS,3,'<match>','</match>') scripture from BibleFTS bible, Book book where bible.scripture match 'blood' and bible.book >= 1 and bible.book<=66 and bible.book = book.id";
    List<SearchResult> searchResultList = jdbcTemplate.query(sql, new SearchResultRowMapper());
    return searchResultList;
  }
}
