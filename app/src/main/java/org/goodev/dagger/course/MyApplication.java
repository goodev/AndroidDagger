package org.goodev.dagger.course;

import android.app.Application;

import org.goodev.dagger.course.di.AppComponent;
import org.goodev.dagger.course.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;


public class MyApplication extends Application implements HasAndroidInjector {
    private AppComponent mAppComponent;
    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        // 使用 factory 来创建部件对象
        mAppComponent = DaggerAppComponent.factory()
                .create(this);
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
