package com.codified.esword.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SearchResult implements Serializable {
    private Integer book;
    private String  title;
    private String  shortTitle;
    private Integer chapter;
    private Integer verse;
    private String  scripture;
}
