package org.goodev.dagger.course.settings;

import org.goodev.dagger.course.user.UserDataRepository;
import org.goodev.dagger.course.user.UserManager;

import javax.inject.Inject;

public class SettingsViewModel {
    private UserDataRepository mDataRepository;
    private UserManager mUserManager;

    @Inject
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
