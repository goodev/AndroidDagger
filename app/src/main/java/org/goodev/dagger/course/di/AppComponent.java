package org.goodev.dagger.course.di;

import android.content.Context;

import org.goodev.dagger.course.MyApplication;
import org.goodev.dagger.course.login.LoginActivityModule;
import org.goodev.dagger.course.registration.RegistrationComponent;
import org.goodev.dagger.course.user.UserManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        LoginActivityModule.class,
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

    // 在 父部件中对外暴露创建子部件对象的工厂类
    RegistrationComponent.Factory registrationComponent();
}
