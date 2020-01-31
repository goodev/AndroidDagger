package org.goodev.dagger.course.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 自定义的 Scope 注解， 用来表示该对象存在的周期和 Activity 的周期一致。
 * 如果 Activity 销毁了，那么里面依赖的对象也会销毁，当 Activity 重建的时候，
 * 使用该 注解的 对象也会重新创建。
 */
@Scope
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
