package com.codified.esword.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codified.esword.model.ScriptureId;
import com.codified.esword.repository.BibleRepository;

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

  @Option(names = {"-c","--context"}, description = "the quick brown fox jumps over the lazy dog", required = true)
  private String context;
  
  @Option(names = {"-s","--search-str"}, required = true)
  private String searchStr;
  
  @Autowired
  BibleRepository bibleRepository;
  
  @Override
  public void run() {
    log.debug("executing ESwordSearchSubCommand.run()...");
    
    System.out.println(bibleRepository.findById(new ScriptureId(1,11,1)));
  }
    
}
