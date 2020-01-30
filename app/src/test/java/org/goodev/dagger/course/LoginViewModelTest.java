package org.goodev.dagger.course;

import org.goodev.dagger.course.login.LoginViewModel;
import org.goodev.dagger.course.user.UserManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginViewModelTest {
    // Executes each task synchronously using Architecture Components.
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    private LoginViewModel mLoginViewModel;
    private UserManager mUserManager;

    @Before
    public void setup() {
        mUserManager = Mockito.mock(UserManager.class);
        mLoginViewModel = new LoginViewModel(mUserManager);
    }


    @Test
    public void getUsername() {
        when(mUserManager.getUsername()).thenReturn("Username");

        String username = mLoginViewModel.getUsername();

        assertEquals("Username", username);
    }

    @Test
    public void loginEmitsSuccess() {
        when(mUserManager.loginUser(anyString(), anyString())).thenReturn(true);

        mLoginViewModel.login("username", "login");

        try {
            assertEquals(LiveDataTestUtil.getValue(mLoginViewModel.getLoginState()), LoginViewModel.LoginViewState.SUCCESS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginEmitsError() {
        when(mUserManager.loginUser(anyString(), anyString())).thenReturn(false);

        mLoginViewModel.login("username", "login");

        try {
            assertEquals(LiveDataTestUtil.getValue(mLoginViewModel.getLoginState()), LoginViewModel.LoginViewState.ERROR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginUnregisters() {
        mLoginViewModel.unregister();

        verify(mUserManager).unregister();
    }
}
