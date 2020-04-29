package com.ckarthickit.dagger.sample.di;

import com.ckarthickit.dagger.sample.Outputter;
import dagger.Module;
import dagger.Provides;


@Module
public abstract class SystemOutModule {
    @Provides
    static Outputter textOutputter() {
        // println is a method with single "string arg" as param and return type as "void"
        // Outputter is a SAM interface that expects a method with the same signature
        // Hence System.out.println method can be substituted in place of Outputter.
        return System.out::println;
    }
}
