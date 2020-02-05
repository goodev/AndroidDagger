package org.goodev.dagger.course.login;

import android.os.Vibrator;

import dagger.Module;
import dagger.Provides;

/**
 * 演示子部件带参数的 模块使用方式
 */
@Module
public class VibratorModule {
    private Vibrator mVibrator;

    public VibratorModule(Vibrator vibrator) {
        mVibrator = vibrator;
    }

    @Provides
    public Vibrator provideVibrate() {
        return mVibrator;
    }
}
