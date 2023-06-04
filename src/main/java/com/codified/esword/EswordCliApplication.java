package com.codified.esword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import com.codified.esword.commands.ESwordCommand;

import picocli.CommandLine;
import picocli.CommandLine.MissingParameterException;
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
			} else {
				commandLine.execute(args);
			}
		} catch (UnmatchedArgumentException unmatchedExc) {	
			System.out.println("Error: " + unmatchedExc.getLocalizedMessage());
			printUsage(commandLine);
		} catch (MissingParameterException missingParamExc) {
			System.out.println("Error: " + missingParamExc.getLocalizedMessage());
			printUsage(commandLine);
		}
	}

	private void printUsage(CommandLine commandLine) {
		CommandLine.usage(commandLine, System.out);
		System.out.println();
	}
}

/*
 drop table if exists WoG;
create virtual table if not exists WoG using fts5(b,c,v,s);
insert into WoG select * from Bible;

select count(*) from Bible;
select count(*) from WoG;

select highlight(verses,3,'<b>','</b>') s from WoG where s match 'H7093';
 
 */