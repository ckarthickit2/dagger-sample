package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.CommandProcessor;
import com.ckarthickit.dagger.sample.di.modules.AnonymousCommandsModule;
import com.ckarthickit.dagger.sample.di.modules.SystemOutModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AnonymousCommandsModule.class,
        SystemOutModule.class,
        UserCommandsRouterSubComponentInstallationModule.class
})
public interface CommandProcessorComponent {

    CommandProcessor processor();

    static CommandProcessorComponent create() {
        return DaggerCommandProcessorComponent.create();
    }
}
