package org.goodev.dagger.course.registration.enterdetails;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.goodev.dagger.course.R;
import org.goodev.dagger.course.registration.RegistrationActivity;
import org.goodev.dagger.course.registration.RegistrationViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EnterDetailsFragment extends Fragment {
    /**
     * RegistrationViewModel 用来管理用户的用户名和密码信息，
     * 和 Activity 的生命周期绑定，并且在多个 Fragment 之间共享信息。
     * EnterDetailsViewModel 用来验证用户输入的信息是否合法，和当前的 Fragment 生命周期绑定。
     * <p>
     * 这里定义这两个简单的 ViewModel 只是为了演示不同生命周期的 ViewModels。
     */
    private RegistrationViewModel mRegistrationViewModel;
    private EnterDetailsViewModel mEnterDetailsViewModel;

    private TextView mErrorTextView;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_details, container, false);

        RegistrationActivity activity = (RegistrationActivity) getActivity();
        mRegistrationViewModel = activity.getRegistrationViewModel();

        mEnterDetailsViewModel = new EnterDetailsViewModel();
        mEnterDetailsViewModel.getEnterDetailsViewState().observe(getViewLifecycleOwner(), state -> {
            if (state instanceof EnterDetailsSuccess) {
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                System.out.println("username = " + username + ", password = " + password );
                mRegistrationViewModel.updateUserData(username, password);
                activity.onDetailsEntered();
            } else if (state instanceof EnterDetailsError) {
                mErrorTextView.setText(((EnterDetailsError) state).mError);
                mErrorTextView.setVisibility(View.VISIBLE);
            }
        });
        setupViews(view);
        return view;
    }

    public void setupViews(View view) {
        mErrorTextView = view.findViewById(R.id.error);
        mUsernameEditText = view.findViewById(R.id.username);
        mUsernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mErrorTextView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mPasswordEditText = view.findViewById(R.id.password);
        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mErrorTextView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        view.findViewById(R.id.next).setOnClickListener(view1 -> {
            String username = mUsernameEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            mEnterDetailsViewModel.validateInput(username, password);
        });
    }

    public static class EnterDetailsViewState {

    }

    public static class EnterDetailsSuccess extends EnterDetailsViewState {

    }

    public static class EnterDetailsError extends EnterDetailsViewState {
        private String mError;

        public EnterDetailsError(String error) {
            mError = error;
        }
    }
}
