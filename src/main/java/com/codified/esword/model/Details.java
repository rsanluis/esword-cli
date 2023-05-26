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
    @Column(name = "Title")
    private String title;    

    @Id
    @NonNull
    @Column(name = "Abbreviation")
    private String abbreviation; 

    @NonNull
    @Column(name = "Information")
    private String information; 

    @NonNull
    @Column(name = "Version")
    private Integer version; 

    @NonNull
    @Column(name = "OldTestament")
    private Integer oldTestament; 

    @NonNull
    @Column(name = "NewTestament")
    private Integer newTestament;
    
    @NonNull
    @Column(name = "Apocrypha")
    private Integer apocrypha;

    @NonNull
    @Column(name = "Strongs")
    private Integer strongs;

    @NonNull
    @Column(name = "RightToLeft")
    private Integer rightToLeft;
}
