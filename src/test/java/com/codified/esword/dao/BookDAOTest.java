package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BookDAOTest {
    @Autowired
    BookDAO bookDAO;

    @Test
    public void testFindAll() {
        List<Book> bookList = bookDAO.findAll();
        assertTrue(bookList.size() == 66);
    }

    @Test
    public void testFindById() {
        Optional<Book> bookOpt = bookDAO.findById(1);
        assertTrue(bookOpt.isPresent());
        Book book = bookOpt.get();
        log.info("book: {}", book);
    }
}
