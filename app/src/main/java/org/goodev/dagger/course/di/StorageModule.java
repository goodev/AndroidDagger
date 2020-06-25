package org.goodev.dagger.course.di;

import org.goodev.dagger.course.storage.SharedPreferencesStorage;
import org.goodev.dagger.course.storage.Storage;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class StorageModule {

    @Binds
    abstract Storage provideStorage(SharedPreferencesStorage storage);

}
