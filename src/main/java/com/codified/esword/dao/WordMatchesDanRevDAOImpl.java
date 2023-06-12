package com.codified.esword.dao;

import org.springframework.stereotype.Service;

@Service
public class WordMatchesDanRevDAOImpl extends WordMatchesBaseDAOImpl implements WordMatchesDanRevDAO {
    public WordMatchesDanRevDAOImpl() {
        this.tableName = "WordMatchesDanRev";
    }
}
