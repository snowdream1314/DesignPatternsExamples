package com.xxq2dream.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.xxq2dream.imageloader.cache.ImageCache;
import com.xxq2dream.imageloader.cache.MemoryCache;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description : 图片加载主模块
 * <p>
 * Author      : Created by xxq on 2017/10/6.
 */


public class ImageLoader {
    // 图片缓存，依赖接口
    ImageCache mImageCache = new MemoryCache();
    // 线程池，线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // 注入缓存,对扩展开放，对修改关闭
    public void setImageCache(ImageCache cache) {
        mImageCache = cache;
    }

    /**
     * 显示图片
     * @param imageUrl
     * @param imageView
     */
    public void displayImage(String imageUrl, ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        // 图片没有缓存，提交到线程池下载
        submitLoadRequest(imageUrl, imageView);
    }

    /**
     * 下载图片
     * @param imageUrl
     * @param imageView
     */
    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if (bitmap == null) {
                    return;
                }
                if (imageUrl.equals(imageView.getTag())) {
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(imageUrl, bitmap);
            }
        });
    }

    /**
     * 下载图片
     * @param imageUrl
     * @return
     */
    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
