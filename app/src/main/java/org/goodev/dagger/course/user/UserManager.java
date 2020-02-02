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
    public static final String TAG = "UserManager";
    public static final String REGISTERED_USER = "registered_user";
    public static final String PASSWORD_SUFFIX = "password";

    private Storage mStorage;
    // 管理用户信息的子部件
    private UserComponent mUserComponent;
    // 用来创建 UserComponent 的工厂实现，由 Dagger 注入
    private UserComponent.Factory mUserComponentFactory;


    @Inject
    public UserManager(Storage storage, UserComponent.Factory factory) {
        mStorage = storage;
        mUserComponentFactory = factory;
    }

    // 对外暴露 UserComponent
    public UserComponent getUserComponent() {
        return mUserComponent;
    }

    // 用户登录后，通过工厂类来创建 UserComponent
    private void userJustLoggedIn() {
        mUserComponent = mUserComponentFactory.create();
    }

    // 用户退出登录的时候， 把 mUserComponent 销毁
    public void logout() {
        mUserComponent = null;
    }

    // 如果 mUserComponent 对象存在，说明用户已经登录
    public boolean isUserLoggedIn() {
        return mUserComponent != null;
    }

    public String getUsername() {
        return mStorage.getString(REGISTERED_USER);
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

    public void unregister() {
        String username = mStorage.getString(REGISTERED_USER);
        mStorage.setString(REGISTERED_USER, "");
        mStorage.setString(username + PASSWORD_SUFFIX, "");
        logout();
    }

}
