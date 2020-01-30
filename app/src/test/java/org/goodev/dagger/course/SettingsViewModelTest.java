package org.goodev.dagger.course;

import org.goodev.dagger.course.settings.SettingsViewModel;
import org.goodev.dagger.course.user.UserDataRepository;
import org.goodev.dagger.course.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SettingsViewModelTest {
    private UserManager userManager;
    private UserDataRepository userDataRepository;
    private SettingsViewModel viewModel;

    @Before
    public void setup() {
        userManager = mock(UserManager.class);
        userDataRepository = mock(UserDataRepository.class);
        viewModel = new SettingsViewModel(userDataRepository, userManager);
    }

    @Test
    public void refreshNotificationsWorksAsExpected() {
        viewModel.refreshNotifications();

        verify(userDataRepository).refreshUnreadNotifications();
    }

    @Test
    public void logoutWorksAsExpected() {
        viewModel.logout();

        verify(userManager).logout();
    }
}
