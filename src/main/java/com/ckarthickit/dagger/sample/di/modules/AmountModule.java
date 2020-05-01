package com.ckarthickit.dagger.sample.di.modules;

import com.ckarthickit.dagger.sample.di.qualifiers.MaximumWithdrawal;
import com.ckarthickit.dagger.sample.di.qualifiers.MinimumBalance;
import dagger.Module;
import dagger.Provides;

import java.math.BigDecimal;

@Module
public class AmountModule {

    @Provides
    @MinimumBalance
    static BigDecimal minimumBalance() {
        return BigDecimal.ZERO;
    }

    @Provides
    @MaximumWithdrawal
    static BigDecimal maximumWithdrawal() {
        return new BigDecimal(1000);
    }
}
