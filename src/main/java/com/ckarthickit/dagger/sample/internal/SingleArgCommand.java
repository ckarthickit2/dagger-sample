package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Command;

import java.util.List;

public abstract class SingleArgCommand implements Command {


    @Override
    public Result handleInput(List<String> input) {
        return (input.size() == 1) ? handleInput(input.get(0)) : Result.invalid();
    }

    protected abstract Result handleInput(String input);
}
