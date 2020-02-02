package org.goodev.dagger.course.di;

import org.goodev.dagger.course.login.LoginComponent;
import org.goodev.dagger.course.registration.RegistrationComponent;
import org.goodev.dagger.course.user.UserManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {StorageModule.class, ContextModule.class, AppSubcomponents.class})
public interface AppComponent {
    UserManager userManager();

    // 在 父部件中对外暴露创建子部件对象的工厂类
    RegistrationComponent.Factory registrationComponent();

    LoginComponent.Factory loginComponent();

}
