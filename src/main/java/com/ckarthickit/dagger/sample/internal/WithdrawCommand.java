package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

public class WithdrawCommand extends BigDecimalCommand {

    private final Database.Account account;
    private final Outputter outputter;

    @Inject
    protected WithdrawCommand(
            Database.Account account,
            Outputter outputter) {
        super(outputter);
        this.account = account;
        this.outputter = outputter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.signum() < 0) {
            outputter.output(String.format("%s, your balance is too low", account.userName()));
        } else {
            account.withdraw(amount);
            outputter.output(String.format("%s your new balance is: %s", account.userName(), account.balance()));
        }
    }
}
