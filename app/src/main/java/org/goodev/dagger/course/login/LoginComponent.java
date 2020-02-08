package org.goodev.dagger.course.login;

import android.os.Vibrator;

import org.goodev.dagger.course.di.ActivityScope;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * 登录界面相关的子部件
 */
@ActivityScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {
    @Subcomponent.Factory
    interface Factory{
        // 工厂模式只需要一个 create 函数，在该函数参数为需要外部提供的对象
        LoginComponent create(@BindsInstance Vibrator vibrator);
    }
    void inject(LoginActivity activity);
}
