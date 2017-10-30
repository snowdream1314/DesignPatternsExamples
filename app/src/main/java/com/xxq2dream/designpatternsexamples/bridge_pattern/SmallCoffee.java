package com.xxq2dream.designpatternsexamples.bridge_pattern;

/**
 * 小杯咖啡
 *
 * @author xxq
 * @date 2017/10/30
 */
public class SmallCoffee extends Coffee {

    public SmallCoffee(CoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的" + impl.addSomething() + "咖啡");
    }
}
