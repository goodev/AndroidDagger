package org.goodev.dagger.coffee;

import dagger.Binds;
import dagger.Module;

/**
 * Module 里面定义依赖关系图中所需要的对象。
 */

@Module
public abstract class PumpModule {
    @Binds
    abstract Pump providePump(Thermosiphon pump);

}
