package com.xxq2dream.designpatternsexamples.factory_pattern;

/**
 * Description : 工厂模式抽象工厂类
 * <p>
 * Author      : Created by xxq on 2017/10/25.
 */


public abstract class Factory {

    /**
     * @param clz 产品对象类型
     * @return 具体的产品类型
     */
    public abstract <T extends Product> T createProduct(Class<T> clz);
}
