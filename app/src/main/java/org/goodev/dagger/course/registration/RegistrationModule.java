package org.goodev.dagger.course.registration;

import org.goodev.dagger.course.di.ActivityScope;
import org.goodev.dagger.course.registration.enterdetails.EnterDetailsFragment;
import org.goodev.dagger.course.registration.termsandconditions.TermsAndConditionsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 定义 Registration 界面相关的子部件
 */
public interface RegistrationModule {
    /**
     * 把 RegistrationActivity 定义为 AppComponent 的子部件
     */
    @Module
    interface ActivityModule {
        @ActivityScope // 把子部件的 Scope 注解放到这里
        // 注意这里的 ContributesAndroidInjector 指定了 FragmentModule.class ，
        // 这样 FragmentModule 里面定义的两个 Fragment 部件就变成了
        // RegistrationActivity 的子部件
        @ContributesAndroidInjector(modules = FragmentModule.class)
        RegistrationActivity contributeRegistrationAndroidInjector();

    }

    /**
     * 定义两个 Fragment 子部件
     */
    @Module
    interface FragmentModule {
        @ContributesAndroidInjector
        EnterDetailsFragment contributeFragmentDetails();

        @ContributesAndroidInjector
        TermsAndConditionsFragment contributeFragmentTac();
    }
}
