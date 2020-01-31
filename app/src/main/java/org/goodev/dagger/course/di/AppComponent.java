package org.goodev.dagger.course.di;

import org.goodev.dagger.course.MainActivity;
import org.goodev.dagger.course.login.LoginActivity;
import org.goodev.dagger.course.registration.RegistrationActivity;
import org.goodev.dagger.course.registration.enterdetails.EnterDetailsFragment;
import org.goodev.dagger.course.registration.termsandconditions.TermsAndConditionsFragment;
import org.goodev.dagger.course.settings.SettingsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {StorageModule.class, ContextModule.class})
public interface AppComponent {
    void inject(RegistrationActivity activity);

    void inject(MainActivity activity);

    void inject(EnterDetailsFragment fragment);

    void inject(TermsAndConditionsFragment fragment);
    void inject(LoginActivity activity);
    void inject(SettingsActivity activity);
}
