package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;
import com.ckarthickit.dagger.sample.SingleArgCommand;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {
    private final Database database;
    private final Outputter outputter;

    @Inject
    public LoginCommand(Database database, Outputter outputter) {
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public Status handleInput(String userName) {
        Database.Account account = database.getAccount(userName);
        outputter.output(userName + " is logged in with balance " + account.balance());
        return Status.HANDLED;
    }
}
