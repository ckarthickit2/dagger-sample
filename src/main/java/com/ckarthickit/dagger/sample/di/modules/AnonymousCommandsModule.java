package com.ckarthickit.dagger.sample.di.modules;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.HelloWorldCommand;
import com.ckarthickit.dagger.sample.internal.LoginCommand;
import dagger.Binds;
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
    abstract Command bindLoginCommand(LoginCommand command);
}
