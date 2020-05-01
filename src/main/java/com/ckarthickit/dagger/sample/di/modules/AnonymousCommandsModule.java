package com.ckarthickit.dagger.sample.di.modules;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.internal.HelloWorldCommand;
import com.ckarthickit.dagger.sample.internal.LoginCommand;
import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface AnonymousCommandsModule {

    @Binds
    @IntoMap
    @StringKey("hello")
    Command bindHelloWorldCommand(HelloWorldCommand command);

    @Binds
    @IntoMap
    @StringKey("login")
    Command bindLoginCommand(LoginCommand command);

    @BindsOptionalOf
    Database.Account loggedInAccount();
}
