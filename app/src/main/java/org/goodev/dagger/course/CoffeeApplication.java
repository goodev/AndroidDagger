package org.goodev.dagger.course;

import android.app.Application;

import org.goodev.dagger.coffee.CoffeeComponent;
import org.goodev.dagger.coffee.DaggerCoffeeComponent;


public class CoffeeApplication extends Application {
    private CoffeeComponent mCoffeeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mCoffeeComponent = DaggerCoffeeComponent.builder().build();

    }

    public CoffeeComponent getCoffeeComponent() {
        return mCoffeeComponent;
    }
}
