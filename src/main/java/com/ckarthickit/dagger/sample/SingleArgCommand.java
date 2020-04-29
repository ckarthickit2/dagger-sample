package com.ckarthickit.dagger.sample;

import java.util.List;

public abstract class SingleArgCommand implements Command {


    @Override
    public Status handleInput(List<String> input) {
        return (input.size() == 1)? handleInput(input.get(0)) : Status.INVALID;
    }

    public abstract Status handleInput(String input);
}
