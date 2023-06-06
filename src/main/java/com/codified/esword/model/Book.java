package com.codified.esword.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @NonNull
    @Column(name = "id")
    private Integer id;    
    
    @NonNull
    @Column(name = "title")
    private String title; 

    @NonNull
    @Column(name = "short_title")
    private String shortTitle; 

    @NonNull
    @Column(name = "chapters")
    private Integer chapters; 
}
