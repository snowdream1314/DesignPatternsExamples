package com.xxq2dream.designpatternsexamples.factory_pattern.iohandle;

import org.junit.Test;

/**
 * 工厂方法测试类
 *
 * @author xxq
 * @date 2017/10/26
 */
public class IoFactoryTest {

    @Test
    public void test() {
        AbstractIoHandler ioHandler = IoFactory.getIoHandler(FileHandler.class);
        System.out.println(ioHandler.query("123456"));
    }

}