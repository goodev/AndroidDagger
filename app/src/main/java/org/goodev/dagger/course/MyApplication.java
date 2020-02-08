package org.goodev.dagger.course;

import android.app.Application;

import org.goodev.dagger.course.di.AppComponent;
import org.goodev.dagger.course.di.DaggerAppComponent;


public class MyApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appContext(this)
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
