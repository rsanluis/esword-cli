package com.codified.esword.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.codified.esword.mapper.WordMatchesRowMapper;
import com.codified.esword.model.WordMatches;

@Service
public abstract class WordMatchesBaseDAOImpl implements WordMatchesBaseDAO {

  protected String tableName;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<WordMatches> getWordMatchesByMatches(Integer matches) {
    return jdbcTemplate.query("select id, word, matches from " + tableName + " where matches = :matches",
        new WordMatchesRowMapper(), matches);
  }

  public List<WordMatches> getWordMatchesByWord(String word) {
    return jdbcTemplate.query("select id, word, matches from " + tableName + " where word = :word",
        new WordMatchesRowMapper(), word);
  }

}
