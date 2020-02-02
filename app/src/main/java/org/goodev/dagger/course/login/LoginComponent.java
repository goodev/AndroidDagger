package org.goodev.dagger.course.login;

import org.goodev.dagger.course.di.ActivityScope;

import dagger.Subcomponent;

/**
 * 登录界面相关的子部件
 */
@ActivityScope
@Subcomponent
public interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }

    void inject(LoginActivity activity);
}
