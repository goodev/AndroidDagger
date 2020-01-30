package org.goodev.dagger.course;

import org.goodev.dagger.course.user.UserDataRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainViewModelTest {
    private UserDataRepository mDataRepository;
    private MainViewModel mMainViewModel;

    @Before
    public void setup() {
        mDataRepository = mock(UserDataRepository.class);
        mMainViewModel =new MainViewModel(mDataRepository);
    }

    @Test
    public  void welcomeTextReturnsRightText() {
        when(mDataRepository.getUsername()).thenReturn("username");
        assertEquals("Hello username!", mMainViewModel.getWelcomeText());
    }

    @Test
    public  void  notificationsTextReturnsRightText() {
        when(mDataRepository.getUnreadNotifications()).thenReturn(5);

        assertEquals("You have 5 unread notifications", mMainViewModel.getNotificationText());
    }
}
