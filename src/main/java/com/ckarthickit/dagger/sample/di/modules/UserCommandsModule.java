package com.ckarthickit.dagger.sample.di.modules;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.DepositCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    public abstract Command bindDepositCommand(DepositCommand depositCommand);
}
