package org.goodev.dagger.course;

import org.goodev.dagger.course.registration.enterdetails.EnterDetailsFragment;
import org.goodev.dagger.course.registration.enterdetails.EnterDetailsViewModel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.assertTrue;

public class EnterDetailsViewModelTest {
    // Executes each task synchronously using Architecture Components.
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    private EnterDetailsViewModel viewModel;

    @Before
    public void setup() {
        viewModel = new EnterDetailsViewModel();
    }

    @Test
    public void validateInputGivesErrorWhenUsernameIsInvalid() throws InterruptedException {
        viewModel.validateInput("user", "password");

        assertTrue(LiveDataTestUtil.getValue(viewModel.getEnterDetailsViewState()) instanceof EnterDetailsFragment.EnterDetailsError);
    }

    @Test
    public void validateInputGivesErrorWhenPasswordIsInvalid() throws InterruptedException {
        viewModel.validateInput("username", "pass");

        assertTrue(LiveDataTestUtil.getValue(viewModel.getEnterDetailsViewState()) instanceof EnterDetailsFragment.EnterDetailsError);
    }

    @Test
    public void validateInputSucceedsWhenInputIsValid() throws InterruptedException {
        viewModel.validateInput("username", "password");

        assertTrue(LiveDataTestUtil.getValue(viewModel.getEnterDetailsViewState()) instanceof EnterDetailsFragment.EnterDetailsSuccess);
    }
}
