package org.goodev.dagger.course.user;

import org.goodev.dagger.course.storage.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 处理用户生命周期。
 * 用户注册、登录、登出功能。
 * 记录用户是否登录。
 */
@Singleton
public class UserManager {
    public static final String REGISTERED_USER = "registered_user";
    public static final String PASSWORD_SUFFIX = "password";

    private Storage mStorage;

    /**
     *  UserDataRepository 管理登录用户的信息。 当用户登录的时候，就创建一个属于该用户的新的
     *  UserDataRepository 对象。当用户登出的时候，UserDataRepository 对象为 null。
     */
    private UserDataRepository mDataRepository;

    @Inject
    public UserManager(Storage storage) {
        mStorage = storage;
    }

    public String getUsername() {
        return mStorage.getString(REGISTERED_USER);
    }

    public UserDataRepository getUserDataRepository() {
        return mDataRepository;
    }

    public boolean isUserLoggedIn() {
        return mDataRepository != null;
    }

    public boolean isUserRegistered() {
        String user = mStorage.getString(REGISTERED_USER);
        return user != null && !user.isEmpty();
    }

    public void registerUser(String username, String password) {
        mStorage.setString(REGISTERED_USER, username);
        mStorage.setString(username + PASSWORD_SUFFIX, password);
        userJustLoggedIn();
    }

    public boolean loginUser(String username, String password) {
        String registeredUser = getUsername();
        if (!registeredUser.equals(username)) {
            return false;
        }

        String registeredPassword = mStorage.getString(username + PASSWORD_SUFFIX);
        if (!registeredPassword.equals(password)) {
            return false;
        }

        userJustLoggedIn();
        return true;
    }

    public void logout() {
        mDataRepository = null;
    }

    public void unregister() {
        String username = mStorage.getString(REGISTERED_USER);
        mStorage.setString(REGISTERED_USER, "");
        mStorage.setString(username + PASSWORD_SUFFIX, "");
        logout();
    }

    private void userJustLoggedIn() {
        mDataRepository = new UserDataRepository(this);
    }

}
