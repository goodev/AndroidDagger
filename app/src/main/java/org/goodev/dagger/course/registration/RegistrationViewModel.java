package org.goodev.dagger.course.registration;

import org.goodev.dagger.course.user.UserManager;

public class RegistrationViewModel {
    private UserManager mUserManager;
    private String mUsername;
    private String mPassword;
    private Boolean mAcceptedTCs;

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
        assert (mUsername != null);
        assert (mPassword != null);
        assert (mAcceptedTCs);
        mUserManager.registerUser(mUsername, mPassword);
    }
}
