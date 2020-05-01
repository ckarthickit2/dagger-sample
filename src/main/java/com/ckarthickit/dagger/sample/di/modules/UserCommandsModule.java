package com.ckarthickit.dagger.sample.di.modules;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.DepositCommand;
import com.ckarthickit.dagger.sample.internal.WithdrawCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    Command bindDepositCommand(DepositCommand depositCommand);

    @Binds
    @IntoMap
    @StringKey("withdraw")
    Command bindWithdrawCommand(WithdrawCommand withdrawCommand);
}
