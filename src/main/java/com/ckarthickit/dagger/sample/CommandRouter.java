package com.ckarthickit.dagger.sample;

import javax.inject.Inject;
import java.util.*;

public class CommandRouter {
    private final Map<String, Command> keyToCommandMap;

    //Injecting a Map<String,Command> instead of a single command.
    @Inject
    public CommandRouter(Map<String,Command> commands){
        keyToCommandMap = commands;
    }

    Command.Result route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        Command command = keyToCommandMap.get(commandKey);
        if (command == null) {
            return invalidCommand(input);
        }

        Command.Result result = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (result.status == Command.Status.INVALID) {
            System.out.println(String.format("%s: Invalid Arguments", commandKey));
        }
        return result;
    }

    Command.Result invalidCommand(String input) {
        System.out.println(String.format("Couldn't understand input: %s. Please try again!", input));
        return Command.Result.invalid();
    }

    private static List<String> split(String string) {
        return  Arrays.asList(string.split(" "));
    }
}