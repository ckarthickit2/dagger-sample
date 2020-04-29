package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.LoginCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class LoginCmdModule {
    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command bindLoginCommand(LoginCommand command);
}
