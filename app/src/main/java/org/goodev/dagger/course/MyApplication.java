package org.goodev.dagger.course;

import android.app.Application;

import org.goodev.dagger.course.di.AppComponent;
import org.goodev.dagger.course.di.DaggerAppComponent;


public class MyApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        // 使用 factory 来创建部件对象
        mAppComponent = DaggerAppComponent.factory()
                .create(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
