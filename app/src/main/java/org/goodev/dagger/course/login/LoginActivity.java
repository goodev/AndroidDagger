package org.goodev.dagger.course.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.goodev.dagger.course.MainActivity;
import org.goodev.dagger.course.MyApplication;
import org.goodev.dagger.course.R;
import org.goodev.dagger.course.registration.RegistrationActivity;
import org.goodev.dagger.course.user.UserManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel mLoginViewModel;
    private TextView mErrorTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MyApplication app = (MyApplication) getApplication();
        UserManager userManager = app.getUserManager();
        // 监听 ViewModel 中的 loginState 状态变化
        mLoginViewModel = new LoginViewModel(userManager);
        mLoginViewModel.getLoginState().observe(this, state -> {
            if (state == LoginViewModel.LoginViewState.SUCCESS) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else if (state == LoginViewModel.LoginViewState.ERROR) {
                mErrorTextView.setVisibility(View.VISIBLE);
            }
        });


        mErrorTextView = findViewById(R.id.error);
        setupViews();
    }

    private void setupViews() {
        EditText usernameEditText = findViewById(R.id.username);
        usernameEditText.setEnabled(false);
        usernameEditText.setText(mLoginViewModel.getUsername());

        EditText passwordEditText = findViewById(R.id.password);
        passwordEditText.addTextChangedListener(new TextWatcher() {
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

        findViewById(R.id.login).setOnClickListener(view -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            mLoginViewModel.login(username, password);
        });

        findViewById(R.id.unregister).setOnClickListener(view -> {
            mLoginViewModel.unregister();
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }


}