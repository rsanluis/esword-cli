package com.codified.esword.commands;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParseResult;

@Command(name = "esword", version = "1.0.0", description = "Command line utility to search the KJV+ Bible", subcommands = {
    ESwordSearchSubCmd.class,
    ESwordWordMatchSubCmd.class
}, synopsisSubcommandLabel = "[COMMAND]")
@Component
public class ESwordCmd implements Callable<Integer> {
  @Option(names = { "-h", "--help" }, description = "Display this help", defaultValue = "false")
  private Boolean displayHelp;

  @Override
  public Integer call() throws Exception {
    CommandLine commandLine = new CommandLine(this);
    ParseResult parseResult = commandLine.getParseResult();
    if (parseResult == null || displayHelp) {
      printUsage(commandLine);
      return 1;
    }
    return 0;
  }

  private void printUsage(CommandLine commandLine) {
    CommandLine.usage(commandLine, System.out);
    System.out.println();
  }
}
