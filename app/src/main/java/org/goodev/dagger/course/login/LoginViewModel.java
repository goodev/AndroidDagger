package org.goodev.dagger.course.login;

import org.goodev.dagger.course.user.UserManager;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class LoginViewModel {
    private UserManager mUserManager;
    private MutableLiveData<LoginViewState> mLoginState = new MutableLiveData<>();

    @Inject
    public LoginViewModel(UserManager userManager) {
        mUserManager = userManager;
    }

    public LiveData<LoginViewState> getLoginState() {
        return mLoginState;
    }

    public void login(String username, String password) {
        if (mUserManager.loginUser(username, password)) {
            mLoginState.setValue(LoginViewState.SUCCESS);
        } else {
            mLoginState.setValue(LoginViewState.ERROR);
        }
    }

    public void unregister() {
        mUserManager.unregister();
    }

    public String getUsername() {
        return mUserManager.getUsername();
    }

    public enum LoginViewState {
        SUCCESS,
        ERROR
    }

}
