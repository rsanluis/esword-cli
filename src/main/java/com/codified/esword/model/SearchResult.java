package com.codified.esword.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SearchResult {
    private Integer book;
    private String  title;
    private String  shortTitle;
    private Integer chapter;
    private Integer verse;
    private String  scripture;
}
