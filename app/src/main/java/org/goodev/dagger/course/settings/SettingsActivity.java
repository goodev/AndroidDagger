package org.goodev.dagger.course.settings;

import android.content.Intent;
import android.os.Bundle;

import org.goodev.dagger.course.MyApplication;
import org.goodev.dagger.course.R;
import org.goodev.dagger.course.login.LoginActivity;
import org.goodev.dagger.course.user.UserManager;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Inject
    SettingsViewModel mSettingsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        MyApplication app = (MyApplication) getApplication();
        app.getAppComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupViews();
    }

    private void setupViews() {
        findViewById(R.id.refresh).setOnClickListener(view -> mSettingsViewModel.refreshNotifications());
        findViewById(R.id.logout).setOnClickListener(view -> {
            mSettingsViewModel.logout();
            Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
}
