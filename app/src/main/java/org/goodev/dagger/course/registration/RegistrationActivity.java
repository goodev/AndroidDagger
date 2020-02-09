package org.goodev.dagger.course.registration;

import android.content.Intent;
import android.os.Bundle;

import org.goodev.dagger.course.MainActivity;
import org.goodev.dagger.course.R;
import org.goodev.dagger.course.registration.enterdetails.EnterDetailsFragment;
import org.goodev.dagger.course.registration.termsandconditions.TermsAndConditionsFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class RegistrationActivity extends AppCompatActivity implements HasAndroidInjector {
    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Inject
    RegistrationViewModel mRegistrationViewModel;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_holder, new EnterDetailsFragment())
                .commit();
    }

    /**
     * 在 EnterDetailsFragment 中输入用户信息后的回调函数
     */
    public void onDetailsEntered() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_holder, new TermsAndConditionsFragment())
                .addToBackStack(TermsAndConditionsFragment.class.getSimpleName())
                .commit();
    }

    /**
     * T&CsFragment 中当条款接受后的回调函数
     */
    public void onTermsAndConditionsAccepted() {
        mRegistrationViewModel.registerUser();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
