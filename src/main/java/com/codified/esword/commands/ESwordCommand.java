package com.codified.esword.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codified.esword.dao.SearchDAO;
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
    log.debug("executing ESwordCliApplication...");
  }
}
