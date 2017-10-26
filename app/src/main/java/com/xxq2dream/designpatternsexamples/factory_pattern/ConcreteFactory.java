package com.xxq2dream.designpatternsexamples.factory_pattern;

/**
 * Description : 工厂模式具体工厂类
 * <p>
 * Author      : Created by xxq on 2017/10/25.
 */
public class ConcreteFactory extends Factory {

    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product p = null;
        try {
            p = (Product) Class.forName(clz.getName()).newInstance();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return (T) p;
    }
}
