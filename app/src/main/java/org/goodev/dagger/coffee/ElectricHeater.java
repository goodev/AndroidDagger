package org.goodev.dagger.coffee;

/**
 * 电加热器，加热器 <code>Heater</code> 的一个具体实现。
 */

public class ElectricHeater implements Heater {
    boolean heating;

    @Override
    public void on() {
        System.out.println("~ ~ ~ 通电加热中 ~ ~ ~");
        this.heating = true;
    }

    @Override
    public void off() {
        this.heating = false;
        System.out.println("--- 断电停止加热 ---");
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}
