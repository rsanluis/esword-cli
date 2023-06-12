package com.codified.esword.dao;

import org.springframework.stereotype.Service;

@Service
public class WordMatchesDanDAOImpl extends WordMatchesBaseDAOImpl implements WordMatchesDanDAO {
    public WordMatchesDanDAOImpl() {
        this.tableName = "WordMatchesDan";
    }
}
