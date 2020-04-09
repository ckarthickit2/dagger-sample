package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Command;

import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {

    @Inject
    public HelloWorldCommand() {

    }

    @Override
    public String key() {
        return "hello";
    }

    @Override
    public Status handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Status.INVALID;
        }
        System.out.println("world!");
        return Status.HANDLED;
    }
}
