package com.codified.esword.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.jspecify.annotations.NonNull;

import com.codified.esword.model.WordMatches;

public class WordMatchesRowMapper implements RowMapper<WordMatches> {

    @Override
    public WordMatches mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        WordMatches wordMatches = new WordMatches();
        wordMatches.setId(rs.getInt("id"));
        wordMatches.setWord(rs.getString("word"));
        wordMatches.setMatches(rs.getInt("matches"));
        return wordMatches;
    }
}
