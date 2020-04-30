package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.CommandRouter;
import com.ckarthickit.dagger.sample.di.modules.AnonymousCommandsModule;
import com.ckarthickit.dagger.sample.di.modules.SystemOutModule;
import com.ckarthickit.dagger.sample.di.modules.UserCommandsModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AnonymousCommandsModule.class, UserCommandsModule.class, SystemOutModule.class,})
public interface CommandRouterFactory {
    CommandRouter router();
}
