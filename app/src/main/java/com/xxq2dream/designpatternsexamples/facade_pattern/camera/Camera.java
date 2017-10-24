package com.xxq2dream.designpatternsexamples.facade_pattern.camera;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public interface Camera {

    //打开相机
    public void open();

    //拍照
    public void takePhoto();

    //关闭相机
    public void close();
}
