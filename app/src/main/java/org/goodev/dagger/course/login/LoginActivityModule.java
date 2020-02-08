package org.goodev.dagger.course.login;

import org.goodev.dagger.course.di.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 删除 LoginComponent 子部件，使用 ContributesAndroidInjector 自动生成
 */
@Module
public interface LoginActivityModule {
    @ActivityScope // 把子部件的 Scope 注解放到这里
    @ContributesAndroidInjector(modules = {LoginModule.class}) // 子部件的模块放到这里
    LoginActivity contributeLoginAndroidInjector();
}
