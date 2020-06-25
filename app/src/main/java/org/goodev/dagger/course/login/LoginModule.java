package org.goodev.dagger.course.login;

import android.graphics.Color;
import android.util.Log;

import org.goodev.dagger.course.di.OnlyDateFormat;
import org.goodev.dagger.course.di.WithTimeDateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * LoginComponent 里面所用到的依赖对象
 */
@Module
@InstallIn(ActivityComponent.class)
public class LoginModule {
    public static final String TAG = "LoginModule";

    // 使用系统定义的 Named 限定符
    @Provides
    @Named("yyyy-MM-dd")
    DateFormat providerYyyyMMddDateFormat() {
        Log.e(TAG, "providerYyyyMMddDateFormat() called");
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    @Provides
    @Named("yyyy-MM-dd hh:mm:ss")
    DateFormat providerYyyyWithTimeFormat() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
    }

    // 自定义 Qualifier
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