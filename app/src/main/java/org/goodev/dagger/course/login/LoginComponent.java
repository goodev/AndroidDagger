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
    @Subcomponent.Builder
    interface Builder{
        // 子部件上通过 @BindsInstance 函数来绑定 Vibrator 对象，
        // 所以之前的 VibratorModule 模块就可以删除不要了。
        @BindsInstance
        Builder vibrator(Vibrator vibrator);

        LoginComponent builder();
    }
    void inject(LoginActivity activity);
}
