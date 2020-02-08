package org.goodev.dagger.course.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.goodev.dagger.course.MainActivity;
import org.goodev.dagger.course.MyApplication;
import org.goodev.dagger.course.R;
import org.goodev.dagger.course.di.OnlyDateFormat;
import org.goodev.dagger.course.di.WithTimeDateFormat;
import org.goodev.dagger.course.registration.RegistrationActivity;

import java.text.DateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Inject
    LoginViewModel mLoginViewModel;

    @Inject
    Vibrator mVibrator;

    // 自定义 Qualifier
    @Inject
    @OnlyDateFormat
    Provider<DateFormat> mDateFormat1;
    @Inject
    @WithTimeDateFormat
    DateFormat mDateTimeFormat2;

    // 使用系统定义的 Named 限定符
    @Inject
    @Named("yyyy-MM-dd")
    Provider<DateFormat> mDateFormat;
    @Inject
    @Named("yyyy-MM-dd hh:mm:ss")
    DateFormat mDateTimeFormat;

    private TextView mErrorTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        MyApplication app = (MyApplication) getApplication();
        Vibrator vibrator = app.getSystemService(Vibrator.class);
        app.getAppComponent()
                .loginComponentBuilder()
                .vibrator(vibrator)
                .builder().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView = findViewById(R.id.textView);
        String date = mDateFormat.get().format(new Date());
        textView.setText(getString(R.string.welcome_dagger_with_date, date));

        mLoginViewModel.getLoginState().observe(this, state -> {
            if (state == LoginViewModel.LoginViewState.SUCCESS) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else if (state == LoginViewModel.LoginViewState.ERROR) {
                String time = mDateTimeFormat.format(new Date());
                mErrorTextView.setText(getString(R.string.login_error_with_time, time));
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
            String date = mDateFormat.get().format(new Date());
            Log.e("TAG", "setupViews: "+date );
        });

        findViewById(R.id.unregister).setOnClickListener(view -> {
            mLoginViewModel.unregister();
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }


}