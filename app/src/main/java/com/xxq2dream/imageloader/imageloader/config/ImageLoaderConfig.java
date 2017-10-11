package com.xxq2dream.imageloader.imageloader.config;

import com.xxq2dream.imageloader.imageloader.cache.ImageCache;
import com.xxq2dream.imageloader.imageloader.cache.MemoryCache;

/**
 * Description : 配置类
 * <p>
 * Author      : Created by xxq on 2017/10/9.
 */


public class ImageLoaderConfig {
    // 图片缓存，依赖接口
    public ImageCache mImageCache = new MemoryCache();

    //加载图片时的loading和加载失败的图片配置对象
    public DisplayConfig displayConfig = new DisplayConfig();

    //线程数量，默认为CPU数量+1；
    public int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    private ImageLoaderConfig() {
    }


    /**
     * 配置类的Builder
     */
    public static class Builder {
        // 图片缓存，依赖接口
        ImageCache mImageCache = new MemoryCache();

        //加载图片时的loading和加载失败的图片配置对象
        DisplayConfig displayConfig = new DisplayConfig();

        //线程数量，默认为CPU数量+1；
        int threadCount = Runtime.getRuntime().availableProcessors() + 1;

        /**
         * 设置线程数量
         * @param count
         * @return
         */
        public Builder setThreadCount(int count) {
            threadCount = Math.max(1, count);
            return this;
        }

        /**
         * 设置图片缓存
         * @param cache
         * @return
         */
        public Builder setImageCache(ImageCache cache) {
            mImageCache = cache;
            return this;
        }

        /**
         * 设置图片加载中显示的图片
         * @param resId
         * @return
         */
        public Builder setLoadingPlaceholder(int resId) {
            displayConfig.loadingImageId = resId;
            return this;
        }

        /**
         * 设置加载失败显示的图片
         * @param resId
         * @return
         */
        public Builder setLoadingFailPlaceholder(int resId) {
            displayConfig.loadingFailImageId = resId;
            return this;
        }

        void applyConfig(ImageLoaderConfig config) {
            config.displayConfig = this.displayConfig;
            config.mImageCache = this.mImageCache;
            config.threadCount = this.threadCount;
        }

        /**
         * 根据已经设置好的属性创建配置对象
         * @return
         */
        public ImageLoaderConfig create() {
            ImageLoaderConfig config = new ImageLoaderConfig();
            applyConfig(config);
            return config;
        }
    }
}
