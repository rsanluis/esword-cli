package com.codified.esword.commands;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codified.esword.dao.SearchDAO;
import com.codified.esword.model.Bible;
import com.codified.esword.model.ScriptureId;
import com.codified.esword.model.SearchResult;
import com.codified.esword.dao.BibleDAO;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Slf4j
@Command(
  name = "esword",
  version = "1.0.0",
  description = "Command line utility to search the KJV+ Bible"
)
@Component
public class ESwordCommand implements Runnable {

  @Option(names = {"-c","--context"}, description = "the search context", required = true)
  private String context;
  
  @Option(names = {"-s","--search-str"}, required = true)
  private String searchStr;
  
  @Autowired
  BibleDAO bibleDAO;

  @Autowired
  SearchDAO searchDAO;
  
  @Override
  public void run() {
    log.debug("executing ESwordSearchSubCommand.run()...");
    
    Bible bible = bibleDAO.getByScriptureId(new ScriptureId(1,1,1));
    String verse = bible.getScripture();
    System.out.println("P1 *** verse: " + verse);

    List<SearchResult> resultList = searchDAO.searchByKeywordAndContext("blood","PaulsLetters");
    int matches = 0;
    int verses  = 0;
    for (SearchResult searchResult : resultList) {
      matches += StringUtils.countMatches(searchResult.getScripture(), SearchDAO.MATCH_START_TAG);
    }
    verses = resultList.size();
    log.info("verses:  {}", verses);
    log.info("matches: {}", matches);
  }
}
