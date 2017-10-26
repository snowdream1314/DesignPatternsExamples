package com.xxq2dream.designpatternsexamples.imageloader.request;

import android.widget.ImageView;

import com.xxq2dream.designpatternsexamples.imageloader.ImageLoader;
import com.xxq2dream.designpatternsexamples.imageloader.config.DisplayConfig;
import com.xxq2dream.designpatternsexamples.imageloader.policy.LoadPolicy;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Description : 图片请求
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class ImageRequest implements Comparable<ImageRequest>{

    public Reference<ImageView> imageViewRef;
    public String imageUrl;
    public DisplayConfig displayConfig;

    /**
     * 是否取消该请求
     */
    public boolean isCanceled = false;

    /**
     * 请求序列号
     */
    public int serialNum = 0;


    /**
     * 加载策略
     */
    private LoadPolicy loadPolicy = ImageLoader.getInstance().getConfig().loadPolicy;


    public ImageRequest(ImageView imageView, String url, DisplayConfig displayConfig) {
        imageViewRef = new WeakReference<ImageView>(imageView);
        this.imageUrl = url;
        this.displayConfig = displayConfig;
        imageView.setTag(url);
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public ImageView getImageView() { return imageViewRef.get(); }

    public String getImageUrl() { return imageUrl; }

    public boolean isImageViewTagValid() {
        return imageViewRef.get() != null ? imageViewRef.get().getTag().equals(imageUrl) : false;
    }

    public void setLoadPolicy(LoadPolicy loadPolicy) {
        if (loadPolicy != null) {
            this.loadPolicy = loadPolicy;
        }
    }

    @Override
    public int compareTo(ImageRequest other) {
        return loadPolicy.compare(this, other);
    }

}
