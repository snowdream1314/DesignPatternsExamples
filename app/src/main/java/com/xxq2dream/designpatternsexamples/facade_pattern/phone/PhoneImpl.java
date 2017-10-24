package com.xxq2dream.designpatternsexamples.facade_pattern.phone;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class PhoneImpl implements Phone {

    @Override
    public void dail() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
