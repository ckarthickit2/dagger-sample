package com.ckarthickit.dagger.sample;

import java.util.List;
import java.util.Optional;

/**
 * Logic to process some input
 */
public interface Command {

    Result handleInput(List<String> input);

    class Result {
        public final Status status;
        public final Optional<CommandRouter> nestedCommandRouter;

        Result(Status status, Optional<CommandRouter> optionalCommandRouter) {
            this.status = status;
            this.nestedCommandRouter = optionalCommandRouter;
        }

        public static Result enterNestedCommandSet(CommandRouter commandRouter) {
            return new Result(Status.HANDLED, Optional.of(commandRouter));
        }

        public static Result invalid() {
            return new Result(Status.INVALID, Optional.empty());
        }

        public static Result handled() {
            return new Result(Status.HANDLED, Optional.empty());
        }

        public static Result inputCompleted() {
            return new Result(Status.INPUT_COMPLETED, Optional.empty());
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
