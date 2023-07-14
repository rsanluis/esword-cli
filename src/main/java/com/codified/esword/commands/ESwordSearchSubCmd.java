package com.codified.esword.commands;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.codified.esword.dao.ContextDAO;
import com.codified.esword.dao.SearchDAO;
import com.codified.esword.model.SearchResult;
import com.codified.esword.util.BibleUtils;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name = "search", description = "Search the KJV+ Bible using Full Text Search")
public class ESwordSearchSubCmd implements Callable<Integer> {

    @Option(names = { "-c", "--context" }, description = "Search context: [Bible, OldTestament, Pentateuch, History, Wisdom, MajorProphets, MinorProphets, NewTestament, GospelsActs, PaulsLetters, GeneralLetters, Apocalypse]")
    private String context;

    @Option(names = { "-s", "--search-str" }, description = "Search string")
    private String searchStr;

    @Option(names = { "-v", "--verbose" }, description = "Verbose mode.  Show Bible verses", defaultValue = "false")
    private Boolean verbose;

    @ParentCommand
    private ESwordCmd eSwordCmd;

    @Autowired
    ContextDAO contextDAO;

    @Autowired
    SearchDAO searchDAO;

    @Override
    public Integer call() throws Exception {
        CommandLine commandLine = new CommandLine(this);
        if (context==null) {
            System.err.println("\nError: Missing search context");
            printUsage(commandLine);
            return 1;
        }
        if (searchStr==null) {
            System.err.println("\nError: Missing search string");
            printUsage(commandLine);
            return 1;
        }
        if (contextDAO.findByContext(context).isEmpty()) {
            System.err.println("\nError: Invalid search context [" + context + "]");
            printUsage(commandLine);
            return 1;
        }
        List<SearchResult> resultsList = searchDAO.searchByKeywordAndContext(searchStr, context);
        int verses = 0;
        int matches = 0;
        matches += BibleUtils.countMatches(resultsList);
        verses = resultsList.size();
        if (verbose) {
            for (SearchResult searchResult : resultsList) {
                System.out.println(searchResult.getScripture());
            }
        }
        System.out.print("verses: " + verses + "   ");
        System.out.println("matches: " + matches);
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
