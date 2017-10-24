package com.xxq2dream.designpatternsexamples.imageloader.loader;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public interface Loader {
    public void loadImage(ImageRequest request);
}
