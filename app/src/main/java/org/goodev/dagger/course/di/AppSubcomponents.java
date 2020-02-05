package org.goodev.dagger.course.di;

import org.goodev.dagger.course.registration.RegistrationComponent;
import org.goodev.dagger.course.user.UserComponent;

import dagger.Module;

/**
 * 通过 @Module 注解的 subcomponents 来引用子部件
 */
@Module(subcomponents = {
        RegistrationComponent.class,
        UserComponent.class
})
public interface AppSubcomponents {
}
