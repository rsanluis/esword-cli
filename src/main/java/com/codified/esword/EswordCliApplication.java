package com.codified.esword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codified.esword.commands.ESwordCmd;

import picocli.CommandLine;
import picocli.CommandLine.ParseResult;
import picocli.spring.PicocliSpringFactory;

@SpringBootApplication
public class EswordCliApplication implements CommandLineRunner {

	@Autowired
	ESwordCmd eSwordCmd;

	@Autowired
	ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(EswordCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CommandLine commandLine = new CommandLine(eSwordCmd, new PicocliSpringFactory(appContext));
		ParseResult parseResult = commandLine.parseArgs(args);
		if (!parseResult.hasSubcommand()) {
			System.err.println("Error: Missing commands");
			printUsage(commandLine);
		} else {
			commandLine.execute(args);
		}
	}

	public void printUsage(CommandLine commandLine) {
		System.out.println();
		CommandLine.usage(commandLine, System.out);
		System.out.println();
	}
}
