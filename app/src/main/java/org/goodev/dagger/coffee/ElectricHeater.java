package org.goodev.dagger.coffee;

import java.util.Random;

/**
 * 电加热器，加热器 <code>Heater</code> 的一个具体实现。
 */
public class ElectricHeater implements Heater {
    boolean heating;
    // 通过该 Tag 可以用来演示不使用 @Singleton 注解的情况，
    // 这样当需要一个 ElectricHeater 的时候每次都会重新创建一个
    String tag;

    public ElectricHeater() {
        tag = "heater " + new Random().nextInt(10);
        System.out.println(tag);
    }

    @Override
    public void on() {
        System.out.println(tag + " ~ ~ ~ 通电加热中 ~ ~ ~");
        this.heating = true;
    }

    @Override
    public void off() {
        this.heating = false;
        System.out.println(tag + " --- 断电停止加热 ---");
    }

    @Override
    public boolean isHot() {
        System.out.println(tag + " *** 水是否烧开 ***");
        return heating;
    }
}
