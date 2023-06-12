package com.codified.esword.dao;

import org.springframework.stereotype.Service;

@Service
public class WordMatchesRevDAOImpl extends WordMatchesBaseDAOImpl implements WordMatchesRevDAO {
    public WordMatchesRevDAOImpl() {
        this.tableName = "WordMatchesRev";
    }
}
