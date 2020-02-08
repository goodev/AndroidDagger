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

    // 在 Builder 上使用 @BindsInstance 来把外部对象绑定到 Dagger
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder appContext(Context context);

        AppComponent build();
    }

    UserManager userManager();

    // 在 父部件中对外暴露创建子部件对象的工厂类
    RegistrationComponent.Factory registrationComponent();

    // 下面是没有在子部件上使用 Builder 的时候，可以直接对外暴露 LoginComponent 本身
    //LoginComponent loginComponent();
    // 当使用了 Builder 的时候， 要通过调用 Builder上的函数来构造子部件，
    // 所以需要对外暴露 子部件的 Builder 对象
    LoginComponent.Builder loginComponentBuilder();

}
