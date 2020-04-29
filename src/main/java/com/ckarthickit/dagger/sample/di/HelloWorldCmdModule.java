package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.HelloWorldCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface HelloWorldCmdModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    Command bindHelloWorldCommand(HelloWorldCommand command);
}
