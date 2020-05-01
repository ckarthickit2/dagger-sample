package com.ckarthickit.dagger.sample.di.modules;

import com.ckarthickit.dagger.sample.Database;
import com.ckarthickit.dagger.sample.di.qualifierexample.Username;
import dagger.Module;
import dagger.Provides;

/**
 * This module is needed as {@link Username} has to be injected from it's associated Component/Sub-Component
 * dependency injections.
 */
@Module
public interface AccountModule {

    /**
     * This provides an Account instance.
     * Account was already optionally injected in few places.
     * So, Dagger would regenerate the code to pick from AccountModule for relevant Sub-Components
     *
     * @param database
     * @param userName
     * @return
     */
    @Provides
    static Database.Account accountFor(
            Database database,
            @Username String userName) {
        return database.getAccount(userName);
    }
}
