package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.Outputter;
import com.ckarthickit.dagger.sample.di.qualifiers.MaximumWithdrawal;
import com.ckarthickit.dagger.sample.di.qualifiers.MinimumBalance;

import javax.inject.Inject;
import java.math.BigDecimal;

public class WithdrawCommand extends BigDecimalCommand {

    private final Outputter outputter;
    private final Database.Account account;
    private final BigDecimal minimumBalance;
    private final BigDecimal maximumWithdrawal;

    @Inject
    protected WithdrawCommand(
            Outputter outputter,
            Database.Account account,
            @MinimumBalance BigDecimal minimumBalance,
            @MaximumWithdrawal BigDecimal maximumWithdrawal
    ) {
        super(outputter);
        this.outputter = outputter;
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        if (amount.compareTo(maximumWithdrawal) > 0) {
            outputter.output(String.format("%s, cannot withdraw more than %s", account.userName(), maximumWithdrawal));
            return;
        }
        BigDecimal newBalance = account.balance().subtract(amount);
        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output(String.format("%s, your balance is too low", account.userName()));
        } else {
            account.withdraw(amount);
            outputter.output(String.format("%s your new balance is: %s", account.userName(), account.balance()));
        }
    }
}
