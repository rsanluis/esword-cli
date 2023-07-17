package com.codified.esword.commands;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import static com.codified.esword.constants.BibleConstants.*;
import com.codified.esword.dao.WordMatchesBibleDAO;
import com.codified.esword.dao.WordMatchesDanDAO;
import com.codified.esword.dao.WordMatchesDanRevDAO;
import com.codified.esword.dao.WordMatchesRevDAO;
import com.codified.esword.model.WordMatches;
import com.codified.esword.util.PrintUtils;

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

    @Autowired
    WordMatchesBibleDAO wordMatchesBibleDAO;

    @Autowired
    WordMatchesDanDAO wordMatchesDanDAO;

    @Autowired
    WordMatchesRevDAO wordMatchesRevDAO;

    @Autowired
    WordMatchesDanRevDAO wordMatchesDanRevDAO;
    
    @Override
    public Integer call() throws Exception {
        System.out.println();
        CommandLine commandLine = new CommandLine(this);
        if (context==null) {
            PrintUtils.printErr("Error: Missing search context");
            printUsage(commandLine);
            return 1;
        }
        if (searchByMatches!=null && searchByWord!=null) {
            PrintUtils.printErr("Error: You need to specify either --matches or --word.  Not both at the same time.");
            printUsage(commandLine);
            return 1;
        }
        if (searchByMatches==null && searchByWord==null) {
            PrintUtils.printErr("Error: You need to specify either --matches or --word");
            printUsage(commandLine);
            return 1;
        }
        if (!context.equals("Bible") && !context.equals("Dan") 
            && !context.equals("DanRev") && !context.equals("Rev")) {
            PrintUtils.printErr("Error: Invalid search context [" + context + "]");
            printUsage(commandLine);
            return 1;
        }
        if (searchByMatches!=null) {
            try {
                Integer.parseInt(searchByMatches);
            } catch (NumberFormatException numExc) {
                PrintUtils.printErr("Error: Invalid number for --matches [" + searchByMatches + "]");
                printUsage(commandLine);
                return 1;
            }
        } else {
            searchByWord = searchByWord.toLowerCase();
        }
        List<WordMatches> wordMatchesList = null;
        switch(context) {
            case "Bible" : {
                wordMatchesList = (searchByMatches!=null) ? wordMatchesBibleDAO.getWordMatchesByMatches(Integer.parseInt(searchByMatches)) :
                    wordMatchesBibleDAO.getWordMatchesByWord(searchByWord);
                break;
            }
            case "Dan" : {
                wordMatchesList = (searchByMatches!=null) ? wordMatchesDanDAO.getWordMatchesByMatches(Integer.parseInt(searchByMatches)) :
                    wordMatchesDanDAO.getWordMatchesByWord(searchByWord);
                break;
            }
            case "DanRev" : {
                wordMatchesList = (searchByMatches!=null) ? wordMatchesDanRevDAO.getWordMatchesByMatches(Integer.parseInt(searchByMatches)) :
                    wordMatchesDanRevDAO.getWordMatchesByWord(searchByWord);
                break;
            }
            case "Rev" : {
                wordMatchesList = (searchByMatches!=null) ? wordMatchesRevDAO.getWordMatchesByMatches(Integer.parseInt(searchByMatches)) :
                    wordMatchesRevDAO.getWordMatchesByWord(searchByWord);
                break;
            }
        }
        if (wordMatchesList!=null) {
            System.out.println(ANSI_BOLD + ANSI_COLOR_CYAN);
            switch(context) {
                case "Bible" : {
                    System.out.println("Matching context is for entire Bible");        
                    break;
                }
                case "Dan" : {
                    System.out.println("Matching context is for Book of Daniel only");
                    break;
                }
                case "DanRev" : {
                    System.out.println("Matching context is for Book of Daniel and Revelation combined");
                    break;
                }
                case "Rev" : {
                    System.out.println("Matching context is for Book of Revelation only");
                    break;
                }
            }
            System.out.println();
            System.out.println(ANSI_RESET);
            System.out.println(ANSI_FG_WHITE_BG_BLUE + PrintUtils.padRight("WORD", 20) + "MATCHES" + ANSI_RESET);
            for (WordMatches wordMatches : wordMatchesList) {
                System.out.println(PrintUtils.padRight(wordMatches.getWord(),20) + ANSI_COLOR_WHITE + ANSI_BOLD + wordMatches.getMatches().toString() + ANSI_RESET);
            }
            System.out.println();
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
