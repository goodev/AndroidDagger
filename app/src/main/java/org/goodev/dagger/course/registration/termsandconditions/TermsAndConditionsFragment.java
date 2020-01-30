package org.goodev.dagger.course.registration.termsandconditions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.goodev.dagger.course.R;
import org.goodev.dagger.course.registration.RegistrationActivity;
import org.goodev.dagger.course.registration.RegistrationViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TermsAndConditionsFragment extends Fragment {

    private RegistrationViewModel mRegistrationViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);
        RegistrationActivity activity = (RegistrationActivity) getActivity();
        mRegistrationViewModel = activity.getRegistrationViewModel();

        view.findViewById(R.id.next).setOnClickListener(view1 -> {
            mRegistrationViewModel.acceptTCs();
            activity.onTermsAndConditionsAccepted();
        });

        return view;
    }
}