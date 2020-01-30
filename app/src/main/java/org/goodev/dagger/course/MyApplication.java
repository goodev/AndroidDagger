package org.goodev.dagger.course;

import android.app.Application;

import org.goodev.dagger.course.storage.SharedPreferencesStorage;
import org.goodev.dagger.course.user.UserManager;


public class MyApplication extends Application {
    private UserManager mUserManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mUserManager = new UserManager(new SharedPreferencesStorage(this));
    }

    public UserManager getUserManager() {
        return mUserManager;
    }
}
