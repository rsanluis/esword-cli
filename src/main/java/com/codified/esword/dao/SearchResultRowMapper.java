package com.codified.esword.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.codified.esword.model.SearchResult;

public class SearchResultRowMapper implements RowMapper<SearchResult> {

    @Override
    public SearchResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        SearchResult searchResult = new SearchResult();
        searchResult.setBook(rs.getInt("book"));
        searchResult.setTitle(rs.getString("title"));
        searchResult.setShortTitle(rs.getString("short_title"));
        searchResult.setChapter(rs.getInt("chapter"));
        searchResult.setVerse(rs.getInt("verse"));
        searchResult.setScripture(rs.getString("scripture"));
        return searchResult;
    }
}
