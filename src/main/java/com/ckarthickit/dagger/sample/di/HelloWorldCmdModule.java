package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.Command;
import com.ckarthickit.dagger.sample.internal.HelloWorldCommand;
import dagger.Binds;
import dagger.Module;

@Module
public interface HelloWorldCmdModule {
    @Binds
    Command bindHelloWorldCommand(HelloWorldCommand command);
}
