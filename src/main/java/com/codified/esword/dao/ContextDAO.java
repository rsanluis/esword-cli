package com.codified.esword.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.codified.esword.model.Context;

@Service
public interface ContextDAO extends JpaRepository<Context, Integer> {
}
