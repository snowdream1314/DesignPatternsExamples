package com.xxq2dream.designpatternsexamples.imageloader.cache;

import android.graphics.Bitmap;

/**
 * Description : 图片缓存接口
 * <p>
 * Author      : Created by xxq on 2017/10/6.
 */


public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url, Bitmap bitmap);
}
