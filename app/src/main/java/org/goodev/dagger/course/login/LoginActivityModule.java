package org.goodev.dagger.course.login;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * 该模块把 LoginComponent 子部件的工厂类绑定到父部件的 Map 集合中
 */
@Module(subcomponents = LoginComponent.class)
public interface LoginActivityModule {
    @Binds
    @IntoMap
    @ClassKey(LoginActivity.class)
    AndroidInjector.Factory<?> loginActivityFactory(LoginComponent.Factory factory);
}
