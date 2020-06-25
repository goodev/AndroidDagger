package org.goodev.dagger.course.user;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * UserDataRepository 保存了用户相关的信息。比如用户名，用户未读消息等。
 */
@Singleton
public class UserDataRepository {
    private String mUserManager;
    private int mUnreadNotifications;

    @Inject
    public UserDataRepository() {
        mUserManager = null;
        mUnreadNotifications = randomInt();
    }

    public String getUsername() {
        return mUserManager;
    }

    public int getUnreadNotifications() {
        return mUnreadNotifications;
    }

    public void refreshUnreadNotifications() {
        mUnreadNotifications = randomInt();
    }


    private int randomInt() {
        return new Random().nextInt(100);
    }

    public void initData(String username) {
        mUnreadNotifications = randomInt();
        mUserManager = username;
    }
}
