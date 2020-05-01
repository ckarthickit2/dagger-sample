package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;

import javax.inject.Inject;
import java.util.List;

public class LogoutCommand implements Command {

    private final Outputter outputter;
    private final Database.Account account;

    @Inject
    LogoutCommand(
            Outputter outputter,
            Database.Account account
    ) {
        this.outputter = outputter;
        this.account = account;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output(String.format("%s logged out!", account.userName()));
        return Result.inputCompleted();
    }
}
