package org.goodev.dagger.coffee;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 依赖注入的部件（Component）。 一个部件对外提供需要使用的对象，该对象所依赖的其他对象
 * Dagger 自动管理。
 */

@Singleton
@Component
public interface CoffeeComponent {
    CoffeeMaker maker();
}
