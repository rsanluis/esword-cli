package com.codified.esword.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codified.esword.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {
}
