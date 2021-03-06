package com.xxq2dream.designpatternsexamples.imageloader.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

/**
 * Description : 内存缓存
 * <p>
 * Author      : Created by xxq on 2017/10/6.
 */


public class MemoryCache implements ImageCache{
    private LruCache<String, Bitmap> mMemoryCache;

    public MemoryCache() {
        //初始化LRU缓存
        initImageCache();
    }

    private void initImageCache() {
        // 计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory()/1024);
        // 取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(ImageRequest request) {
        return mMemoryCache.get(request.getImageUrl());
    }

    @Override
    public void put(ImageRequest request, Bitmap bitmap) {
        mMemoryCache.put(request.getImageUrl(), bitmap);
    }
}
