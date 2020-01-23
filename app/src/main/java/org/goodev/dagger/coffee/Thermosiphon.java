package org.goodev.dagger.coffee;

import javax.inject.Inject;

/**
 * 热虹吸式抽水泵，需要<code> Heater </code> 对象，抽水泵 <code>Pump</code> 的实现。
 */

public class Thermosiphon implements Pump {
    private final Heater heater;

    @Inject
    public Thermosiphon(ElectricHeater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("=> => 冲水中 => =>");
        }
    }
}
