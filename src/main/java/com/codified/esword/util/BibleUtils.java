package com.codified.esword.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.codified.esword.dao.SearchDAO;
import com.codified.esword.model.SearchResult;

public class BibleUtils {

    public static int countMatches(List<SearchResult> resultsList) {
        int matches =0;
        for (SearchResult searchResult : resultsList) {
            matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
        }
        return matches;
    }

    public static int getHebrewGematriaValue(String word) {
        int hebrewGematriaValue = 0;
        for (int i=0; i<word.length(); i++) {
            String charStr = "" + word.charAt(i);
            charStr = charStr.toUpperCase();
            if (BibleUtils.hebrewGematriaMap.containsKey(charStr)) {
                hebrewGematriaValue += BibleUtils.hebrewGematriaMap.get(charStr).intValue();
            }
        }
        return hebrewGematriaValue;
    }

    public static int getSimpleGematriaValue(String word) {
        int simpleGematriaValue = 0;
        for (int i=0; i<word.length(); i++) {
            String charStr = "" + word.charAt(i);
            charStr = charStr.toUpperCase();
            if (BibleUtils.simpleGematriaMap.containsKey(charStr)) {
                simpleGematriaValue += BibleUtils.simpleGematriaMap.get(charStr).intValue();
            }
        }
        return simpleGematriaValue;
    }

    // Hebrew Gematria Table obtained from https://www.gematrix.org/gematria/#jewish_gematria
    public static final Map<String, Integer> hebrewGematriaMap = Map.ofEntries(
        Map.entry("A",1),
        Map.entry("א",1),
        Map.entry("ב",2),
        Map.entry("B",2),
        Map.entry("ג",3),
        Map.entry("C",3),
        Map.entry("D",4),
        Map.entry("ד",4),
        Map.entry("E",5),
        Map.entry("ה",5),
        Map.entry("ו",6),
        Map.entry("F",6),
        Map.entry("ז",7),
        Map.entry("G",7),
        Map.entry("ח",8),
        Map.entry("H",8),
        Map.entry("I",9),
        Map.entry("ט",9),
        Map.entry("י",10),
        Map.entry("K",10),
        Map.entry("כ",20),
        Map.entry("ך",20),
        Map.entry("L",20),
        Map.entry("M",30),
        Map.entry("ל",30),
        Map.entry("מ",40),
        Map.entry("ם",40),
        Map.entry("N",40),
        Map.entry("O",50),
        Map.entry("ן",50),
        Map.entry("נ",50),
        Map.entry("P",60),
        Map.entry("ס",60),
        Map.entry("ע",70),
        Map.entry("Q",70),
        Map.entry("ף",80),
        Map.entry("R",80),
        Map.entry("פ",80),
        Map.entry("ץ",90),
        Map.entry("צ",90),
        Map.entry("S",90),
        Map.entry("T",100),
        Map.entry("ק",100),
        Map.entry("U",200),
        Map.entry("ר",200),
        Map.entry("ש",300),
        Map.entry("X",300),
        Map.entry("ת",400),
        Map.entry("Y",400),
        Map.entry("Z",500),
        Map.entry("J",600),
        Map.entry("V",700),
        Map.entry("W",900)
    );

    // English Gematria Table obtained from https://www.gematrix.org/gematria/#english_gematria
    public static final Map<String, Integer> englishGematriaMap = Map.ofEntries(
        Map.entry("A",6),
        Map.entry("B",12),
        Map.entry("C",18),
        Map.entry("D",24),
        Map.entry("E",30),
        Map.entry("F",36),
        Map.entry("G",42),
        Map.entry("H",48),
        Map.entry("I",54),
        Map.entry("J",60),
        Map.entry("K",66),
        Map.entry("L",72),
        Map.entry("M",78),
        Map.entry("N",84),
        Map.entry("O",90),
        Map.entry("P",96),
        Map.entry("Q",102),
        Map.entry("R",108),
        Map.entry("S",114),
        Map.entry("T",120),
        Map.entry("U",126),
        Map.entry("V",132),
        Map.entry("W",138),
        Map.entry("X",144),
        Map.entry("Y",150),
        Map.entry("Z",156)
    );

    public static final Map<String, Integer> simpleGematriaMap = Map.ofEntries(
        Map.entry("A",1),
        Map.entry("B",2),
        Map.entry("C",3),
        Map.entry("D",4),
        Map.entry("E",5),
        Map.entry("F",6),
        Map.entry("G",7),
        Map.entry("H",8),
        Map.entry("I",9),
        Map.entry("J",10),
        Map.entry("K",11),
        Map.entry("L",12),
        Map.entry("M",13),
        Map.entry("N",14),
        Map.entry("O",15),
        Map.entry("P",16),
        Map.entry("Q",17),
        Map.entry("R",18),
        Map.entry("S",19),
        Map.entry("T",20),
        Map.entry("U",21),
        Map.entry("V",22),
        Map.entry("W",23),
        Map.entry("X",24),
        Map.entry("Y",25),
        Map.entry("Z",26)
    );
    

}
