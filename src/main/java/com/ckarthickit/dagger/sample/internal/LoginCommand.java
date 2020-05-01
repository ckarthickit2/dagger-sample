package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;
import com.ckarthickit.dagger.sample.di.UserCommandsRouterSubComponent;

import javax.inject.Inject;
import java.util.Optional;

public class LoginCommand extends SingleArgCommand {
    private final Outputter outputter;
    private final Optional<Database.Account> accountOptional;
    private final UserCommandsRouterSubComponent.Factory userCommandRouterFactory;

    @Inject
    public LoginCommand(
            Optional<Database.Account> accountOptional,
            Outputter outputter,
            UserCommandsRouterSubComponent.Factory userCommandRouterFactory
    ) {
        this.accountOptional = accountOptional;
        this.outputter = outputter;
        this.userCommandRouterFactory = userCommandRouterFactory;
    }

    @Override
    public Result handleInput(String userName) {
        if (accountOptional.isPresent()) {
            String loggedInUser = accountOptional.get().userName();
            outputter.output(loggedInUser + " already logged in");
            if (!loggedInUser.equals(userName)) {
                outputter.output("run `logout` first before trying to log in another user");
            }
            return Result.handled();
        } else {
            UserCommandsRouterSubComponent subComponent = userCommandRouterFactory.create(userName);
            outputter.output("Logged in " + userName);
            return Result.enterNestedCommandSet(subComponent.userCommandRouter());
        }

    }
}
