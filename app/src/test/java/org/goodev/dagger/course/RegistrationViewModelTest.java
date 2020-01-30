package org.goodev.dagger.course;

import org.goodev.dagger.course.registration.RegistrationViewModel;
import org.goodev.dagger.course.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RegistrationViewModelTest {
    private UserManager userManager;
    private RegistrationViewModel viewModel;

    @Before
    public void setup() {
        userManager = mock(UserManager.class);
        viewModel = new RegistrationViewModel(userManager);
    }

    @Test
    public void RegisterUserCallsUserManager() {
        viewModel.updateUserData("username", "password");
        viewModel.acceptTCs();
        viewModel.registerUser();

        verify(userManager).registerUser("username", "password");
    }
}
