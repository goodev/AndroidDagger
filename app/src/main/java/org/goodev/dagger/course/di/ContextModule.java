package org.goodev.dagger.course.di;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import org.goodev.dagger.course.user.User;

import java.util.Comparator;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

@Module
@InstallIn(ApplicationComponent.class)
public class ContextModule {

    @Provides // 说明这是一个对象提供函数
    @IntoMap // 说明该函数提供的对象被放到一个 Map value 中
    @IntKey(Sensor.TYPE_STEP_COUNTER)
        // 定义 Map 的 key
    Sensor providerStepSensor(@ApplicationContext Context context) {
        SensorManager manager = context.getSystemService(SensorManager.class);
        return manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    @Provides
    @IntoMap
    @IntKey(Sensor.TYPE_ACCELEROMETER)
    Sensor providerAccSensor(@ApplicationContext Context context) {
        SensorManager manager = context.getSystemService(SensorManager.class);
        return manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Provides
    @IntoMap
    @IntKey(Sensor.TYPE_GRAVITY)
    Sensor providerGravitySensor(@ApplicationContext Context context) {
        SensorManager manager = context.getSystemService(SensorManager.class);
        return manager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    }

    @Provides
    @IntoMap
    @IdTypeKey(IdType.TYPE_ID_CARD)
    Comparator<User> providerUserComparator() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.username.compareTo(o2.username); // TODO 实现这个
            }
        };
    }

}
