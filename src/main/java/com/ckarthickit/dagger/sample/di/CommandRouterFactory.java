package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.CommandRouter;
import dagger.Component;

@Component(modules = { HelloWorldCmdModule.class, LoginCmdModule.class, SystemOutModule.class, })
public interface CommandRouterFactory {
    CommandRouter router();
}
