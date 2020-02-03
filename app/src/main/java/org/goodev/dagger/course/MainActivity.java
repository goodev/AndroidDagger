package org.goodev.dagger.course;

import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.goodev.dagger.course.di.IdType;
import org.goodev.dagger.course.login.LoginActivity;
import org.goodev.dagger.course.registration.RegistrationActivity;
import org.goodev.dagger.course.settings.SettingsActivity;
import org.goodev.dagger.course.user.User;
import org.goodev.dagger.course.user.UserManager;

import java.util.Comparator;
import java.util.Map;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mMainViewModel;

    @Inject
    Map<Integer, Sensor> mSensorMap;
    @Inject
    Map<IdType, Comparator<User>> mIdComparatorMap;

    UserManager mUserManager;
    private TextView mNotificationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        MyApplication app = (MyApplication) getApplication();
        mUserManager = app.getAppComponent().userManager();
        if (!mUserManager.isUserLoggedIn()) {
            if (!mUserManager.isUserRegistered()) {
                startActivity(new Intent(this, RegistrationActivity.class));
                finish();
            } else {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        } else {
            // 如果用户已登录，则从 mUserManager 中获取 UserComponent 子部件并注入该 Activity
            mUserManager.getUserComponent().inject(this);
            setupViews();
        }
    }

    private void setupViews() {
        mNotificationView = findViewById(R.id.notifications);
        TextView hello = findViewById(R.id.hello);
        hello.setText(mMainViewModel.getWelcomeText());

        Button settings = findViewById(R.id.settings);
        settings.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SettingsActivity.class)));
    }

    @Override
    public void onResume() {
        super.onResume();
        mNotificationView.setText(mMainViewModel.getNotificationText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}