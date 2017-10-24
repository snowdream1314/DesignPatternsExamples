package com.xxq2dream.designpatternsexamples.imageloader.listener;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public interface ImageListener {
    public void onComplete(ImageView imageView, Bitmap bitmap, String url);
}
