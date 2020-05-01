package com.ckarthickit.dagger.sample.qualifierexample;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AccountModule.class)
public interface AccountsFactory {
    Account account();

    @Component.Factory
    interface Factory {
        AccountsFactory create(@BindsInstance @Username String userName);
    }
}
