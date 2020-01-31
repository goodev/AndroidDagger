package org.goodev.dagger.coffee;

import org.goodev.dagger.course.MainActivity;

/**
 * 依赖注入的部件（Component）。 一个部件对外提供需要使用的对象，该对象所依赖的其他对象
 * Dagger 自动管理。
 * TODO 使用 用户注册 示例项目后， 该  Component  无用了。
 */

//@Singleton
//@Component(modules = {DripCoffeeModule.class})
public interface CoffeeComponent {
    CoffeeMaker maker();

    void injectActivity(MainActivity activity);
}
