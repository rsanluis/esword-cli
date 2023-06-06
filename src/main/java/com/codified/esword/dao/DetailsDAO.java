package com.codified.esword.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codified.esword.model.Details;

public interface DetailsDAO extends JpaRepository<Details, String> {
}
