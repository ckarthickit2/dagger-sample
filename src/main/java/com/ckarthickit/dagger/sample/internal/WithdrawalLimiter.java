package com.ckarthickit.dagger.sample.internal;

import com.ckarthickit.dagger.sample.di.qualifiers.MaximumWithdrawal;
import com.ckarthickit.dagger.sample.di.scopes.PerSession;

import javax.inject.Inject;
import java.math.BigDecimal;

@PerSession
public final class WithdrawalLimiter {

    private BigDecimal remainingWithdrawalLimit;

    @Inject
    public WithdrawalLimiter(@MaximumWithdrawal BigDecimal maximumWithdrawalLimit) {
        this.remainingWithdrawalLimit = maximumWithdrawalLimit;
    }

    public void recordWithdrawal(BigDecimal withdrawalAmount) {
        this.remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(withdrawalAmount);
    }

    public void recordDeposit(BigDecimal depositAmount) {
        this.remainingWithdrawalLimit = remainingWithdrawalLimit.add(depositAmount);
    }

    BigDecimal remainingWithdrawalLimit() {
        return remainingWithdrawalLimit;
    }
}
