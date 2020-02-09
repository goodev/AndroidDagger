package org.goodev.dagger.course.di;

import android.content.Context;

import org.goodev.dagger.course.MyApplication;
import org.goodev.dagger.course.login.LoginActivityModule;
import org.goodev.dagger.course.registration.RegistrationModule;
import org.goodev.dagger.course.user.UserManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        LoginActivityModule.class,
        RegistrationModule.ActivityModule.class,
        StorageModule.class,
        ContextModule.class,
        AppSubcomponents.class
})
public interface AppComponent {

    // 用来注入 MyApplication 中的变量
    void inject(MyApplication app);

    // 在 Factory 上使用 @BindsInstance 来把外部对象绑定到 Dagger
    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context context);
    }

    UserManager userManager();
}
