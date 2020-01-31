package org.goodev.dagger.course.user;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * UserDataRepository 保存了用户相关的信息。比如用户名，用户未读消息等。
 */
//TODO 暂时使用单例
@Singleton
public class UserDataRepository {
    private UserManager mUserManager;
    private int mUnreadNotifications;

    @Inject
    public UserDataRepository(UserManager userManager) {
        mUserManager = userManager;
        mUnreadNotifications = randomInt();
    }

    public String getUsername() {
        return mUserManager.getUsername();
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

}
