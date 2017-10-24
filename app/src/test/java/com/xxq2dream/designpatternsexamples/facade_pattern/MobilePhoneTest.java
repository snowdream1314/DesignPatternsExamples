package com.xxq2dream.designpatternsexamples.facade_pattern;

import org.junit.Test;

/**
 * Description : 外观模式测试类
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */

public class MobilePhoneTest {
    @Test
    public void dail() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.dail();
    }

    @Test
    public void hangup() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.hangup();
    }

    @Test
    public void openCamera() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.openCamera();
    }

    @Test
    public void takePhoto() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.takePhoto();
    }

    @Test
    public void closeCamera() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.closeCamera();
    }

}