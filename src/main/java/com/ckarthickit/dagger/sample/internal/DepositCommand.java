package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

public class DepositCommand extends BigDecimalCommand {

    private final Database.Account account;
    private final Outputter outputter;
    private final WithdrawalLimiter withdrawalLimiter;

    @Inject
    public DepositCommand(
            Database.Account account,
            Outputter outputter,
            WithdrawalLimiter withdrawalLimiter) {
        super(outputter);
        this.account = account;
        this.outputter = outputter;
        this.withdrawalLimiter = withdrawalLimiter;
    }


    @Override
    protected void handleAmount(BigDecimal depositAmount) {
        account.deposit(depositAmount);
        withdrawalLimiter.recordDeposit(depositAmount);
        outputter.output(account.userName() + " now has " + account.balance());
    }
}
