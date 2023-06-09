package com.codified.esword.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class WordMatches {
    private Integer id;
    private String word; 
    private Integer matches; 
}
