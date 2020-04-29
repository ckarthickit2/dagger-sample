package com.ckarthickit.dagger.sample;

import com.ckarthickit.dagger.sample.internal.HelloWorldCommand;

import javax.inject.Inject;
import java.util.*;

public class CommandRouter {
    private static final Map<String, Command> keyToCommandMap = new HashMap<>();

    @Inject
    public CommandRouter(Command command){
        keyToCommandMap.put(command.key(), command);
    }

    Command.Status route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        Command command = keyToCommandMap.get(commandKey);
        if (command == null) {
            return invalidCommand(input);
        }

        Command.Status status = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (status == Command.Status.INVALID) {
            System.out.println(String.format("%s: Invalid Arguments", commandKey));
        }
        return status;
    }

    Command.Status invalidCommand(String input) {
        System.out.println(String.format("Couldn't understand input: %s. Please try again!", input));
        return Command.Status.INVALID;
    }

    private static List<String> split(String string) {
        return  Arrays.asList(string.split(" "));
    }
}