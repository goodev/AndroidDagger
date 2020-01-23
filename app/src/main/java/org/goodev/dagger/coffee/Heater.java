package org.goodev.dagger.coffee;

/**
 * 咖啡机的加热器。
 */

public interface Heater {
    void on();

    void off();

    boolean isHot();
}