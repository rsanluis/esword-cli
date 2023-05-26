package com.codified.esword.commands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codified.esword.model.Details;
import com.codified.esword.model.ScriptureId;
import com.codified.esword.repository.BibleRepository;
import com.codified.esword.repository.DetailsRepository;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;

@Slf4j
@Command(
  name = "search"
)
@Component
public class ESwordSearchSubCommand implements Runnable {

    @Autowired
    DetailsRepository detailsRepository;

    @Autowired
    BibleRepository bibleRepository;

    @Override
    public void run() {
      log.debug("executing ESwordSearchSubCommand.run()...");
      
      System.out.println(bibleRepository.findById(new ScriptureId(1,1,1)));
      
    }
    
}
