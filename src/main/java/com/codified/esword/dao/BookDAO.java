package com.codified.esword.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.codified.esword.model.Book;

@Service
public interface BookDAO extends JpaRepository<Book, Integer> {
}
