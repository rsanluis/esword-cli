package com.codified.esword.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codified.esword.model.Details;

public interface DetailsRepository extends JpaRepository<Details, String> {
}
