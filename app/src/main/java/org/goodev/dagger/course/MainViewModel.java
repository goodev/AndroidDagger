package org.goodev.dagger.course;

import org.goodev.dagger.course.user.UserDataRepository;

public class MainViewModel {
    private UserDataRepository mRepository;


    public MainViewModel(UserDataRepository repository) {
        mRepository = repository;
    }

    public String getWelcomeText() {
        return "Hello " + mRepository.getUsername()+"!";
    }

    public String getNotificationText() {
        return "You have " + mRepository.getUnreadNotifications() + " unread notifications";
    }
}
