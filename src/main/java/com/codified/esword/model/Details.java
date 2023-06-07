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
@Table(name = "Details")
public class Details {
    @NonNull
    @Column(name = "title")
    private String title;    

    @Id
    @NonNull
    @Column(name = "abbreviation")
    private String abbreviation; 

    @NonNull
    @Column(name = "information")
    private String information; 

    @NonNull
    @Column(name = "version")
    private Integer version; 

    @NonNull
    @Column(name = "oldtestament")
    private Integer oldTestament;

    @NonNull
    @Column(name = "newtestament")
    private Integer newTestament;
    
    @NonNull
    @Column(name = "apocrypha")
    private Integer apocrypha;

    @NonNull
    @Column(name = "strongs")
    private Integer strongs;

    @NonNull
    @Column(name = "righttoleft")
    private Integer rightToLeft;
}
