package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.Outputter;

import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output("howdy!");
        return Result.handled();
    }
}
