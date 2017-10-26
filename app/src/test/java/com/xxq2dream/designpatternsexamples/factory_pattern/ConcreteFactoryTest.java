package com.xxq2dream.designpatternsexamples.factory_pattern;

import org.junit.Test;

/**
 * Description :
 * <p>
 * Author      : Created by xx on 2017/10/25.
 */

public class ConcreteFactoryTest {

    @Test
    public void test() {
        Factory factory = new ConcreteFactory();
        Product productA = factory.createProduct(ProductA.class);
        Product productB = factory.createProduct(ProductB.class);
        productA.method();
        productB.method();
    }
}