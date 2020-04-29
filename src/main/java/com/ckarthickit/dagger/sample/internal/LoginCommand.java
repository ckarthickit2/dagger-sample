package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Outputter;
import com.ckarthickit.dagger.sample.SingleArgCommand;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;

    @Inject
    public LoginCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return "login";
    }

    @Override
    public Status handleInput(String userName) {
        outputter.output(userName + " is logged in.");
        return Status.HANDLED;
    }
}
