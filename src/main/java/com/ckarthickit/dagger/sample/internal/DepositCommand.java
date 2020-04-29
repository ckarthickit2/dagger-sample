package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class DepositCommand implements Command {

    private final Database database;
    private final Outputter outputter;

    @Inject
    public DepositCommand(Database database, Outputter outputter) {
        this.database = database;
        this.outputter = outputter;
    }

    @Override
    public Status handleInput(List<String> input) {
        if (input.size() != 2) {
            return Status.INVALID;
        }
        String userName = input.get(0);
        BigDecimal depositAmount = new BigDecimal(input.get(1));
        Database.Account account = database.getAccount(userName);
        account.deposit(depositAmount);
        outputter.output(account.userName() + " now has " + account.balance());
        return Status.HANDLED;
    }
}
