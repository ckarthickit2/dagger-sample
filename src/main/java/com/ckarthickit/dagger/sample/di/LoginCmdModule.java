package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.LoginCommand;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginCmdModule {
    @Binds
    abstract Command bindLoginCommand(LoginCommand command);
}
