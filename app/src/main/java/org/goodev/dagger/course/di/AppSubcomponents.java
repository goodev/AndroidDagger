package org.goodev.dagger.course.di;

import org.goodev.dagger.course.login.LoginComponent;
import org.goodev.dagger.course.registration.RegistrationComponent;

import dagger.Module;

/**
 * 通过 @Module 注解的 subcomponents 来引用子部件
 */
@Module(subcomponents = {RegistrationComponent.class, LoginComponent.class})
public interface AppSubcomponents {
}
