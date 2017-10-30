package com.xxq2dream.designpatternsexamples.bridge_pattern;

/**
 * 咖啡父类
 *
 * @author xxq
 * @date 2017/10/30
 */
public abstract class Coffee {
    protected CoffeeAdditives impl;

    public Coffee (CoffeeAdditives impl) {
        this.impl = impl;
    }

    /**
     * 咖啡具体是什么样的由子类决定
     */
    public abstract void makeCoffee();
}
