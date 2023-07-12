package com.codified.esword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.codified.esword.commands.ESwordCmd;

import picocli.CommandLine;
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
		commandLine.execute(args);
	}
}
