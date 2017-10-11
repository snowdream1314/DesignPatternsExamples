package com.xxq2dream.designpatternsexamples.observer_pattern;

import org.junit.Test;

/**
 * Description : 观察者测试用例
 * <p>
 * Author      : Created by xxq on 2017/10/11.
 */

public class ObserverPatternTest {
    @Test
    public void test1() throws Exception {
        MyObservable myObservable = new MyObservable();

        MyObserver myObserver1 = new MyObserver("observer-1");
        MyObserver myObserver2 = new MyObserver("observer-2");
        myObservable.addObserver(myObserver1);
        myObservable.addObserver(myObserver2);

        //发布消息
        myObservable.sendChangeMeg("发布更新啦");
    }

}