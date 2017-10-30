package com.xxq2dream.designpatternsexamples.bridge_pattern;

/**
 * 咖啡添加父类
 *
 * @author xxq
 * @date 2017/10/30
 */
public abstract class CoffeeAdditives {

    /**
     * 具体添加什么东西由子类决定
     *
     * @return 添加的东西，比如加糖
     */
    public abstract String addSomething();
}
