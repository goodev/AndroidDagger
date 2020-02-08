package org.goodev.dagger.course.login;

import android.os.Vibrator;

/**
 * 在子部件使用 @BindsInstance 后，该模块可以删除了
 */
//@Module
public class VibratorModule {
    private Vibrator mVibrator;

    public VibratorModule(Vibrator vibrator) {
        mVibrator = vibrator;
    }

    //@Provides
    public Vibrator provideVibrate() {
        return mVibrator;
    }
}
