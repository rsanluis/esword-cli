package com.codified.esword.dao;

import java.util.List;

import com.codified.esword.model.WordMatches;

public interface WordMatchesBaseDAO {
  public List<WordMatches> getWordMatchesByMatches(Integer matches);
  public List<WordMatches> getWordMatchesByWord(String word);
}
