package org.goodev.dagger.course.di;

import android.content.Context;

import org.goodev.dagger.course.login.LoginComponent;
import org.goodev.dagger.course.registration.RegistrationComponent;
import org.goodev.dagger.course.user.UserManager;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {StorageModule.class, ContextModule.class, AppSubcomponents.class})
public interface AppComponent {

    // 在 Factory 上使用 @BindsInstance 来把外部对象绑定到 Dagger
    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context context);
    }

    // 当使用了 Factory 的时候， 要通过调用 Factory 的 create函数来构造子部件，
    // 所以需要对外暴露 子部件的 Factory 对象
    LoginComponent.Factory loginComponentFactory();


    UserManager userManager();

    // 在 父部件中对外暴露创建子部件对象的工厂类
    RegistrationComponent.Factory registrationComponent();
}
