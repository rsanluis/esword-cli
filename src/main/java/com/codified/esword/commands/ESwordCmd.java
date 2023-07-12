package com.codified.esword.commands;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;

@Command(name = "esword", version = "1.0.0", description = "Command line utility to search the KJV+ Bible", subcommands = {
    ESwordSearchSubCmd.class,
    ESwordWordMatchSubCmd.class
}, synopsisSubcommandLabel = "[COMMAND]")
@Component
public class ESwordCmd {
}
