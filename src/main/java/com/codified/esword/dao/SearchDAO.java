package com.codified.esword.dao;

import java.util.List;

import com.codified.esword.model.SearchResult;

public interface SearchDAO {
  public List<SearchResult> searchByKeyword(String keyword);
}
