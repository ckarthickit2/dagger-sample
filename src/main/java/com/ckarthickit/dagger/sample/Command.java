package com.ckarthickit.dagger.sample;

import java.util.List;

/**
 * Logic to process some input
 */
public interface Command {
    String key();

    Status handleInput(List<String> input);

    enum Status {
        INVALID,
        HANDLED
    }
}
