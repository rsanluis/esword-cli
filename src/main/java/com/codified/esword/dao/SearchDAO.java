package com.codified.esword.dao;

import java.util.List;

import com.codified.esword.model.SearchResult;

public interface SearchDAO {

  public final static String MATCH_START_TAG = "<match>";
  public final static String MATCH_END_TAG = "</match>";

  public List<SearchResult> searchByBookChapterAndVerse(String bookName, Integer chapterId, Integer verseId);
  public List<SearchResult> searchByKeywordAndContext(String keyword, String context);
  public List<SearchResult> searchByKeywordAndBookIDs(String keyword, List<Integer> bookIDs);
}
