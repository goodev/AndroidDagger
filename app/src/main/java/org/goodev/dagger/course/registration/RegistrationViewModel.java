package org.goodev.dagger.course.registration;

import org.goodev.dagger.course.user.UserManager;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class RegistrationViewModel {
    private UserManager mUserManager;
    private String mUsername;
    private String mPassword;
    private Boolean mAcceptedTCs;

    @Inject
    public RegistrationViewModel(UserManager userManager) {
        mUserManager = userManager;
    }


    public void updateUserData(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public void acceptTCs() {
        mAcceptedTCs = true;
    }

    public void registerUser() {
        if (mUsername == null) {
            throw new RuntimeException("username can not be null");
        }
        if (mPassword == null) {
            throw new RuntimeException("password can not be null");
        }

        if (!mAcceptedTCs) {
            throw new RuntimeException("must accept Terms");
        }
        mUserManager.registerUser(mUsername, mPassword);
    }
}
