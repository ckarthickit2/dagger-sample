package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.CommandRouter;
import com.ckarthickit.dagger.sample.di.modules.AccountModule;
import com.ckarthickit.dagger.sample.di.modules.AmountModule;
import com.ckarthickit.dagger.sample.di.modules.UserCommandsModule;
import com.ckarthickit.dagger.sample.di.qualifierexample.Username;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@Subcomponent(modules = {
        UserCommandsModule.class,
        AccountModule.class,
        AmountModule.class
})
public interface UserCommandsRouterSubComponent {

    CommandRouter userCommandRouter();

    /**
     * The SubComponent Factory instance can also be injected as dependency.
     *
     * @see com.ckarthickit.dagger.sample.internal.LoginCommand
     */
    @Subcomponent.Factory
    interface Factory {
        UserCommandsRouterSubComponent create(@BindsInstance @Username String userName);
    }

}

/**
 * This establishes the relationship between {@link CommandProcessorComponent} and
 * {@link UserCommandsRouterSubComponent}
 */
@Module(subcomponents = UserCommandsRouterSubComponent.class)
interface UserCommandsRouterSubComponentInstallationModule {
}
