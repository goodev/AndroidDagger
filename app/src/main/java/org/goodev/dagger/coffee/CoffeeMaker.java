package org.goodev.dagger.coffee;

import javax.inject.Inject;

/**
 * 咖啡机，一个咖啡机需要有加热器和抽水泵来加热水和把热水抽出来。
 */
public class CoffeeMaker {
    private final Heater heater;
    private final Pump pump;

    @Inject
    public CoffeeMaker(Pump pump, Heater heater) {
        this.heater = heater;
        this.pump = pump;
    }

    /**
     * 启动冲咖啡
     */
    public void brew() {
        heater.on();
        pump.pump();
        System.out.println("^_^ 咖啡已冲好 ^_^ ");
        heater.off();
    }
}
