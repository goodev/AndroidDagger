package org.goodev.dagger.coffee;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = PumpModule.class)
public class DripCoffeeModule {
    @Provides
    @Singleton
    Heater provideHeater() {
        // 通过 Provides 来提供 Heater 对象，这样的话 ElectricHeater
        // 就不需要带 Inject 的构造函数了
        return new ElectricHeater();
    }
}
