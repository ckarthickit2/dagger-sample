package com.ckarthickit.dagger.sample.qualifierexample;

import dagger.Module;
import dagger.Provides;

@Module
public interface AccountModule {
    @Provides
    static Account accountFor(@Username String userName) {
        System.out.println("username is " + userName);
        return new Account(userName);
    }
}
