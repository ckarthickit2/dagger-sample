package com.ckarthickit.dagger.sample;

import java.util.List;

/**
 * Logic to process some input
 */
public interface Command {

    Status handleInput(List<String> input);

    enum Status {
        INVALID,
        HANDLED
    }
}
