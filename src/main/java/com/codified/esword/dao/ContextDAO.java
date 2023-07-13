package com.codified.esword.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.codified.esword.model.Context;

@Service
public interface ContextDAO extends JpaRepository<Context, Integer> {
    @Query(value = "select ctx from Context ctx where ctx.context = :context")
    public List<Context> findByContext(@Param("context") String context);
}
