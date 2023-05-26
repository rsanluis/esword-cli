package com.codified.esword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import com.codified.esword.commands.ESwordCommand;

import picocli.CommandLine;
import picocli.CommandLine.ParseResult;
import picocli.CommandLine.UnmatchedArgumentException;
import picocli.spring.PicocliSpringFactory;

@SpringBootApplication
public class EswordCliApplication implements CommandLineRunner {

	@Autowired
	ESwordCommand eSwordCommand;

	@Autowired
	ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(EswordCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		CommandLine commandLine = new CommandLine(eSwordCommand, new PicocliSpringFactory(appContext));
		System.out.println();

		try {
			ParseResult parseResult = commandLine.parseArgs(args);
			if (CollectionUtils.isEmpty(parseResult.expandedArgs())) {
				printUsage(commandLine);
				System.exit(1);	
			}
			int exitCode = commandLine.execute(args);
			System.exit(exitCode);
		} catch (UnmatchedArgumentException unmatchedExc) {	
			System.out.println("Error: Invalid argument specified: " + unmatchedExc.getUnmatched());
			printUsage(commandLine);
			System.exit(1);
		}
	}

	private void printUsage(CommandLine commandLine) {
		CommandLine.usage(commandLine, System.out);
		System.out.println();
	}
}
