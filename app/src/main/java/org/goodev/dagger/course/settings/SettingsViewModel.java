package org.goodev.dagger.course.settings;

import org.goodev.dagger.course.user.UserDataRepository;
import org.goodev.dagger.course.user.UserManager;

public class SettingsViewModel {
    private UserDataRepository mDataRepository;
    private UserManager mUserManager;

    public SettingsViewModel(UserDataRepository dataRepository, UserManager userManager) {
        mDataRepository = dataRepository;
        mUserManager = userManager;
    }

    public void refreshNotifications() {
        mDataRepository.refreshUnreadNotifications();
    }

    public void logout() {
        mUserManager.logout();
    }
}
