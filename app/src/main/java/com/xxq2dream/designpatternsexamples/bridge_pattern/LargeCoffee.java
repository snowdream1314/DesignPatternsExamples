package com.xxq2dream.designpatternsexamples.bridge_pattern;

/**
 * 大杯的咖啡
 *
 * @author xxq
 * @date 2017/10/30
 */
public class LargeCoffee extends Coffee {

    public LargeCoffee(CoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的" + impl.addSomething() + "咖啡");
    }
}
