package com.xxq2dream.designpatternsexamples.bridge_pattern;

import org.junit.Test;

/**
 * 桥接模式测试
 *
 * @author xxq
 * @date 2017/10/30
 */
public class CoffeeTest {

    @Test
    public void test() {
        //原味
        Ordinary ordinary = new Ordinary();

        //加糖
        Sugar sugar = new Sugar();

        //大杯咖啡，原味
        LargeCoffee largeCoffee = new LargeCoffee(ordinary);
        largeCoffee.makeCoffee();

        //小杯咖啡，原味
        SmallCoffee smallCoffee = new SmallCoffee(ordinary);
        smallCoffee.makeCoffee();

        //大杯咖啡，加糖
        LargeCoffee largeCoffeeSugar = new LargeCoffee(sugar);
        largeCoffeeSugar.makeCoffee();

        //小杯咖啡，加糖
        SmallCoffee smallCoffeeSugar = new SmallCoffee(sugar);
        smallCoffeeSugar.makeCoffee();
    }

}