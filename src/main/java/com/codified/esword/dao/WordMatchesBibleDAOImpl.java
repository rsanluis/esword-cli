package com.codified.esword.dao;

import org.springframework.stereotype.Service;

@Service
public class WordMatchesBibleDAOImpl extends WordMatchesBaseDAOImpl implements WordMatchesBibleDAO {
  public WordMatchesBibleDAOImpl() {
    this.tableName = "WordMatchesBible";
  }
}
