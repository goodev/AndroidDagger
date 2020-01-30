package org.goodev.dagger.course;

import org.goodev.dagger.course.storage.FakeStorage;
import org.goodev.dagger.course.user.UserManager;

public class MyTestApplication extends MyApplication {

    private  UserManager mFakeManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mFakeManager = new UserManager(new FakeStorage());
    }

    @Override
    public UserManager getUserManager() {
        return mFakeManager;
    }
}
