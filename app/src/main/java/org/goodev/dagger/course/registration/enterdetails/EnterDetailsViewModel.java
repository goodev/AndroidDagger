package org.goodev.dagger.course.registration.enterdetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EnterDetailsViewModel {
    public static final int MAX_LENGTH = 5;
    private MutableLiveData<EnterDetailsFragment.EnterDetailsViewState> mEnterDetailsState = new MutableLiveData<>();

    public LiveData<EnterDetailsFragment.EnterDetailsViewState> getEnterDetailsViewState() {
        return mEnterDetailsState;
    }

    public void validateInput(String username, String password) {
        if (username.length() < MAX_LENGTH) {
            mEnterDetailsState.setValue(new EnterDetailsFragment.EnterDetailsError("Username has to be longer than 4 characters"));
        } else if (password.length() < MAX_LENGTH) {
            mEnterDetailsState.setValue(new EnterDetailsFragment.EnterDetailsError("Password has to be longer than 4 characters"));
        } else {
            mEnterDetailsState.setValue(new EnterDetailsFragment.EnterDetailsSuccess());
        }

    }
}
