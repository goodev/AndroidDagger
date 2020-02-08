package org.goodev.dagger.course.login;

import org.goodev.dagger.course.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * 登录界面相关的子部件
 */
@ActivityScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent extends AndroidInjector<LoginActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<LoginActivity> {
    }
}
