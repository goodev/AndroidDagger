package org.goodev.dagger.course.login;

import org.goodev.dagger.course.di.ActivityScope;

import dagger.Subcomponent;

/**
 * 登录界面相关的子部件
 */
@ActivityScope
@Subcomponent(modules = {LoginModule.class, VibratorModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
