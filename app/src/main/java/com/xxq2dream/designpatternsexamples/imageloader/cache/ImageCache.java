package com.xxq2dream.designpatternsexamples.imageloader.cache;

import android.graphics.Bitmap;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

/**
 * Description : 图片缓存接口
 * <p>
 * Author      : Created by xxq on 2017/10/6.
 */


public interface ImageCache {
    public Bitmap get(ImageRequest request);
    public void put(ImageRequest request, Bitmap bitmap);
}
