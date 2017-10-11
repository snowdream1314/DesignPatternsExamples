package com.xxq2dream.designpatternsexamples.observer_pattern;

import java.util.Observable;

/**
 * Description : 被观察者
 * <p>
 * Author      : Created by xxq on 2017/10/11.
 */


public class MyObservable extends Observable{
    public void sendChangeMeg(String content) {
        //方法继承自Observable，标示状态或是内容发生改变
        setChanged();

        //方法继承自Observable，通知所有观察者，最后会调用每个Observer的update方法
        notifyObservers(content);
    }
}
