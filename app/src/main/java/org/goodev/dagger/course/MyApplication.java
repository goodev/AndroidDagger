package org.goodev.dagger.course;

import android.app.Application;

import org.goodev.dagger.course.di.AppComponent;
import org.goodev.dagger.course.di.ContextModule;
import org.goodev.dagger.course.di.DaggerAppComponent;


public class MyApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
