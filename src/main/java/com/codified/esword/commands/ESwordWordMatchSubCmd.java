package com.codified.esword.commands;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name= "wordmatch", description = "Search the KJV+ Bible using Word Matches")
public class ESwordWordMatchSubCmd implements Callable<Integer> {

    @Option(names = { "-c", "--context" }, description = "Search context: [Bible, Dan, DanRev, Rev]")
    private String context;

    @Option(names = { "-m", "--matches" }, description = "Search by matches")
    private String searchByMatches;

    @Option(names = { "-w", "--word" }, description = "Search by word")
    private String searchByWord;

    @ParentCommand
    private ESwordCmd eSwordCmd;
    
    @Override
    public Integer call() throws Exception {
        CommandLine commandLine = new CommandLine(this);
        if (context==null) {
            System.err.println("\nError: Missing search context");
            printUsage(commandLine);
            return 1;
        }
        if (searchByMatches!=null && searchByWord!=null) {
            System.err.println("\nError: You need to specify either --matches or --word.  Not both at the same time.");
            printUsage(commandLine);
            return 1;
        }
        if (searchByMatches==null && searchByWord==null) {
            System.err.println("\nError: You need to specify either --matches or --word");
            printUsage(commandLine);
            return 1;
        }
        if (!context.equals("Bible") && !context.equals("Dan") 
            && !context.equals("DanRev") && !context.equals("Rev")) {
            System.err.println("\nError: Invalid search context [" + context + "]");
            printUsage(commandLine);
            return 1;
        }
        return 0;
    }

    public void printUsage(CommandLine commandLine) {
        System.out.println();
        CommandLine parentCmdLine = new CommandLine(eSwordCmd);
        commandLine.setCommandName(parentCmdLine.getCommandName() + " " + commandLine.getCommandName());
        CommandLine.usage(commandLine, System.out);
        System.out.println();
    }
}
