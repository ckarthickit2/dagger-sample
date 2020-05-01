package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.di.modules.UserCommandsModule;
import com.ckarthickit.dagger.sample.di.qualifierexample.Username;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@Subcomponent(modules = UserCommandsModule.class)
public interface UserCommandsRouterSubComponent {

    @Subcomponent.Factory
    interface Factory {
        UserCommandsRouterSubComponent create(@BindsInstance @Username String userName);
    }
}

//This establishes the relationship between CommandProcessorComponent and UserCommandsRouterSubComponent
@Module(subcomponents = UserCommandsRouterSubComponent.class)
interface UserCommandsRouterSubComponentInstallationModule {
}
