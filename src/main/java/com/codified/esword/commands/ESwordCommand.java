package com.codified.esword.commands;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;

@Slf4j
@Command(
  name = "esword",
  subcommands = {
    ESwordSearchSubCommand.class,
  }
)
@Component
public class ESwordCommand implements Runnable {

    @Override
    public void run() {
        log.debug("executing ESwordCommand.run()...");
    }
    
}
