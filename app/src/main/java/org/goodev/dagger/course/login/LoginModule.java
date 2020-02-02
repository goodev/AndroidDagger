package org.goodev.dagger.course.login;

import android.graphics.Color;

import org.goodev.dagger.course.di.OnlyDateFormat;
import org.goodev.dagger.course.di.WithTimeDateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * LoginComponent 里面所用到的依赖对象
 */
@Module
public class LoginModule {
    @Provides
    @OnlyDateFormat
    DateFormat providerDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    @Provides
    @WithTimeDateFormat
    DateFormat providerDateTimeFormat() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
    }


    @Provides
    @Named("username")
    public int usernameErrorColor() {
        return Color.RED;
    }

    @Provides
    @Named("password")
    public int passwordErrorColor() {
        return Color.MAGENTA;
    }
}