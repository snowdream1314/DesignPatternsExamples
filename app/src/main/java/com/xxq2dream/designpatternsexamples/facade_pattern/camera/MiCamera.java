package com.xxq2dream.designpatternsexamples.facade_pattern.camera;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class MiCamera implements Camera {

    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePhoto() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭相机");
    }
}
