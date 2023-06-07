package com.codified.esword.util;

import java.util.List;

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
}
