package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.CommandRouter;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {HelloWorldCmdModule.class, LoginCmdModule.class, DepositCmdModule.class, SystemOutModule.class,})
public interface CommandRouterFactory {
    CommandRouter router();
}
