package org.goodev.dagger.course.registration;

import org.goodev.dagger.course.di.ActivityScope;
import org.goodev.dagger.course.registration.enterdetails.EnterDetailsFragment;
import org.goodev.dagger.course.registration.termsandconditions.TermsAndConditionsFragment;

import dagger.Subcomponent;

/**
 * 在 RegistrationComponent 中，所有使用 @ActivityScope 的依赖对象都将使用同一个对象。
 * 也就是说，在 RegistrationComponent 中，使用 @ActivityScope 注解的对象是唯一的。
 */
@ActivityScope
@Subcomponent // 通过 @Subcomponent 注解来定义一个子部件
public interface RegistrationComponent {

    // 用来创建 RegistrationComponent 对象的工厂方法
    @Subcomponent.Factory
    interface Factory {
        RegistrationComponent create();
    }

    // 该子部件需要注入的类
    void inject(RegistrationActivity activity);

    void inject(EnterDetailsFragment fragment);

    void inject(TermsAndConditionsFragment fragment);
}
