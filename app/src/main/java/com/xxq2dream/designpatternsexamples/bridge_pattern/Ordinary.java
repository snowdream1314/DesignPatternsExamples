package com.xxq2dream.designpatternsexamples.bridge_pattern;

/**
 * 原味咖啡
 *
 * @author xxq
 * @date 2017/10/30
 */
public class Ordinary extends CoffeeAdditives {

    @Override
    public String addSomething() {
        return "原味";
    }
}
