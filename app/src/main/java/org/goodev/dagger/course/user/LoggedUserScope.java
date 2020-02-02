package org.goodev.dagger.course.user;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 自定义的代表 已登录用户 的范围
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggedUserScope {
}
