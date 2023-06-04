package com.codified.esword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codified.esword.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
