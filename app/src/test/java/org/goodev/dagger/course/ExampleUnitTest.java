package org.goodev.dagger.course;

import org.goodev.dagger.coffee.CoffeeComponent;
import org.goodev.dagger.coffee.CoffeeMaker;
import org.goodev.dagger.coffee.DaggerCoffeeComponent;
import org.goodev.dagger.coffee.ElectricHeater;
import org.goodev.dagger.coffee.Thermosiphon;
import org.junit.Test;

/**
 * 由于在新版本的 Android Studio 和 Gradle 中无法直接在安卓项目中运行 Java 程序 , 函数
 * <code>public static void main(String[] args) </code> 无法运行，所以为了测试示例代码，
 * 通过运行 JUnit 代码来运行示例代码。测试函数 <code>testCoffeeMaker</code> 相当于 Java
 * 程序的入口函数。
 */
public class ExampleUnitTest {
    @Test
    public void testCoffeeMaker() {
        ElectricHeater heater = new ElectricHeater();
        Thermosiphon pump = new Thermosiphon(heater);
        CoffeeMaker coffeeMaker = new CoffeeMaker(pump,heater);
        coffeeMaker.brew();
    }

    @Test
    public void testDaggerCoffeeMaker() {
        CoffeeComponent c = DaggerCoffeeComponent.builder().build();
        CoffeeMaker maker = c.maker();
        maker.brew();
    }
}