package com.ckarthickit.dagger.sample.di.qualifierexample;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AccountModule.class)
public interface AccountsComponent {
    Account account();

    @Component.Factory
    interface Factory {
        AccountsComponent create(@BindsInstance @Username String userName);
    }
}
