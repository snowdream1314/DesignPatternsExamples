package com.xxq2dream.designpatternsexamples.observer_pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Description : 观察者
 * <p>
 * Author      : Created by xxq on 2017/10/11.
 */


public class MyObserver implements Observer{
    private String mName;

    public MyObserver(String name) {
        mName = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(mName + "-->" + "update: " + arg);
    }
}
