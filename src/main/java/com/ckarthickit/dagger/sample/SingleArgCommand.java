package com.ckarthickit.dagger.sample;

import java.util.List;

public abstract class SingleArgCommand implements Command {


    @Override
    public Result handleInput(List<String> input) {
        return (input.size() == 1) ? handleInput(input.get(0)) : Result.invalid();
    }

    public abstract Result handleInput(String input);
}
