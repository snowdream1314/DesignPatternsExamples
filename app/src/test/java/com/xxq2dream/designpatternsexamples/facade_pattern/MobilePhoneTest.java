package com.xxq2dream.designpatternsexamples.facade_pattern;

import org.junit.Test;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */

public class MobilePhoneTest {
    @Test
    public void takePhoto() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.takePhoto();
    }

    @Test
    public void videoChat() throws Exception {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.videoChat();
    }

}