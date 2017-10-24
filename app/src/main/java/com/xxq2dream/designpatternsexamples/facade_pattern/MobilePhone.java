package com.xxq2dream.designpatternsexamples.facade_pattern;

import com.xxq2dream.designpatternsexamples.facade_pattern.camera.Camera;
import com.xxq2dream.designpatternsexamples.facade_pattern.camera.MiCamera;
import com.xxq2dream.designpatternsexamples.facade_pattern.phone.Phone;
import com.xxq2dream.designpatternsexamples.facade_pattern.phone.PhoneImpl;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class MobilePhone {
    private Phone mPhone = new PhoneImpl();
    private Camera mCamera = new MiCamera();

    public void dail() {
        mPhone.dail();
    }

    public void hangup() {
        mPhone.hangup();
    }

    public void openCamera() {
        mCamera.open();
    }

    public void takePhoto() {
        mCamera.takePhoto();
    }

    public void closeCamera() {
        mCamera.close();
    }

}
