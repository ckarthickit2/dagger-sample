package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.CommandRouter;
import dagger.Component;

@Component(modules = HelloWorldCmdModule.class)
public interface CommandRouterFactory {
    CommandRouter router();
}
