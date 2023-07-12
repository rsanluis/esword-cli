package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.Context;

@SpringBootTest
public class ContextDAOTest {
    @Autowired
    ContextDAO contextDAO;

    @Test
    public void testFindAll() {
        List<Context> contextList = contextDAO.findAll();
        assertTrue(contextList.size() == 12);
    }

    @Test
    public void testFindById() {
        Optional<Context> contextOpt = contextDAO.findById(5);
        assertTrue(contextOpt.isPresent());
        Context context = contextOpt.get();
        assertTrue(context.getContext().equals("Wisdom"));
        assertTrue(context.getStartId() == 18);
        assertTrue(context.getEndId() == 22);
    }

    @Test
    void testFindByContext() {
        List<Context> contextList = contextDAO.findByContext("NewTestament");
        assertTrue(contextList.size()==1);
    }

    @Test
    void testFindByContextNotFound() {
        List<Context> contextList = contextDAO.findByContext("ContextNotFound");
        assertTrue(contextList.isEmpty());
    }
}
