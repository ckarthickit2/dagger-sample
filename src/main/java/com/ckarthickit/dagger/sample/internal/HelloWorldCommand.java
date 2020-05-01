package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class HelloWorldCommand implements Command {

    private final Outputter outputter;
    private final Optional<Database.Account> accountOptional;

    @Inject
    public HelloWorldCommand(
            Optional<Database.Account> accountOptional,
            Outputter outputter) {
        this.outputter = outputter;
        this.accountOptional = accountOptional;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        if (accountOptional.isPresent()) {
            outputter.output(String.format("howdy %s !", accountOptional.get().userName()));
        } else {
            outputter.output("howdy!");
        }
        return Result.handled();
    }
}
