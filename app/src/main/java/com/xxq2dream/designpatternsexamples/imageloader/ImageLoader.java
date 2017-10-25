package com.xxq2dream.designpatternsexamples.imageloader;

import android.widget.ImageView;

import com.xxq2dream.designpatternsexamples.imageloader.cache.ImageCache;
import com.xxq2dream.designpatternsexamples.imageloader.cache.MemoryCache;
import com.xxq2dream.designpatternsexamples.imageloader.config.DisplayConfig;
import com.xxq2dream.designpatternsexamples.imageloader.config.ImageLoaderConfig;
import com.xxq2dream.designpatternsexamples.imageloader.queue.RequestQueue;
import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

/**
 * Description : 图片加载主模块
 * <p>
 * Author      : Created by xxq on 2017/10/6.
 */


public class ImageLoader {
    //图片加载配置
    ImageLoaderConfig mConfig;

    // 图片缓存，依赖接口
    ImageCache mImageCache = new MemoryCache();

    //请求队列
    private RequestQueue requestQueue;

    private static ImageLoader mImageLoader = null;
    private ImageLoader () {}

    public static ImageLoader getInstance() {
        if (mImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (mImageLoader == null) {
                    mImageLoader = new ImageLoader();
                }
            }
        }
        return mImageLoader;

    }

    public void init(ImageLoaderConfig config) {
        mConfig = config;
        mImageCache = config.mImageCache;
        checkConfig();

        requestQueue = new RequestQueue(config.threadCount);
        requestQueue.start();
    }

    private void checkConfig() {

        if (mConfig == null) {
            throw new RuntimeException(
                    "The config of ImageLoader is null.Please call the init(ImageLoaderConfig config) method to initialize");
        }

        if (mImageCache == null) {
            mImageCache = new MemoryCache();
        }
    }

    public ImageLoaderConfig getConfig() {
        return mConfig;
    }


    public void displayImage(final ImageView imageView, String url) {
        displayImage(imageView, url, null);
    }

    public void displayImage(final ImageView imageView, String url, DisplayConfig config) {
        ImageRequest request = new ImageRequest(imageView, url, config);
        request.displayConfig = request.displayConfig != null ? request.displayConfig : mConfig.displayConfig;
        requestQueue.addRequest(request);
    }

    public void stop() {
        requestQueue.stop();
    }


}
