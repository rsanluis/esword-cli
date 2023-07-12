package com.codified.esword.commands;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.codified.esword.dao.ContextDAO;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name = "search", description = "Search the KJV+ Bible using Full Text Search")
public class ESwordSearchSubCmd implements Callable<Integer> {

    @Option(names = { "-h", "--help" }, description = "Display this help", defaultValue = "false")
    private Boolean displayHelp;

    @Option(names = { "-c", "--context" }, description = "Search context: [Bible, OldTestament, Pentateuch, History, Wisdom, MajorProphets, MinorProphets, NewTestament, GospelsActs, PaulsLetters, GeneralLetters, Apocalypse]")
    private String context;

    @Option(names = { "-s", "--search-str" }, description = "Search string")
    private String searchStr;

    @ParentCommand
    private ESwordCmd eSwordCmd;

    @Autowired
    ContextDAO contextDAO;

    @Override
    public Integer call() throws Exception {
        CommandLine commandLine = new CommandLine(this);
        if (displayHelp) {
            printUsage(commandLine);
            return 1;
        }
        if (context==null) {
            System.err.println("Error: Missing search context");
            printUsage(commandLine);
            return 1;
        }
        if (searchStr==null) {
            System.err.println("Error: Missing search string");
            printUsage(commandLine);
            return 1;
        }
        if (contextDAO.findByContext(context).isEmpty()) {
            System.err.println("Error: Invalid search context [" + context + "]");
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
