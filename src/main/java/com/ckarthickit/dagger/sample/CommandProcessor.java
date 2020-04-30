package com.ckarthickit.dagger.sample;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayDeque;
import java.util.Deque;

@Singleton
public final class CommandProcessor {
    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    public CommandProcessor(CommandRouter firstCommandRouter) {
        commandRouterStack.push(firstCommandRouter);
    }

    Command.Status process(String input) {
        if (commandRouterStack.isEmpty()) {
            throw new IllegalStateException("No command router is available!");
        }

        Command.Result result = commandRouterStack.peek().route(input);
        switch (result.status) {
            case INPUT_COMPLETED: {
                commandRouterStack.pop();
                return commandRouterStack.isEmpty() ? Command.Status.INPUT_COMPLETED : Command.Status.HANDLED;
            }
            case HANDLED: {
                result.nestedCommandRouter.ifPresent(commandRouterStack::push);
            }
            //Intentional FallThrough
            case INVALID: {
                return result.status;
            }
        }
        throw new AssertionError(result.status);
    }

}
