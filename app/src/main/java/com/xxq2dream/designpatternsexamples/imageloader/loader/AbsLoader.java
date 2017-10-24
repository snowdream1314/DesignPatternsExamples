package com.xxq2dream.designpatternsexamples.imageloader.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.xxq2dream.designpatternsexamples.imageloader.ImageLoader;
import com.xxq2dream.designpatternsexamples.imageloader.cache.ImageCache;
import com.xxq2dream.designpatternsexamples.imageloader.config.DisplayConfig;
import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public abstract class AbsLoader implements Loader {

    //图片缓存
    private ImageCache imageCache = ImageLoader.getInstance().getConfig().mImageCache;

    @Override
    public void loadImage(ImageRequest request) {
        Bitmap bitmap = imageCache.get(request);
        if (bitmap == null) {
            showLoadingImage(request);

            bitmap = onLoadImage(request);
            cacheImage(request, bitmap);
        }

        deliverToUIThread(request, bitmap);
    }

    public abstract Bitmap onLoadImage(ImageRequest request);

    private void showLoadingImage(final ImageRequest request) {
        final ImageView imageView = request.getImageView();
        if (request.isImageViewTagValid() && hasLoadingPlaceHolder(request.displayConfig)) {
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageResource(request.displayConfig.loadingImageId);
                }
            });
        }
    }


    private void cacheImage(ImageRequest request, Bitmap bitmap) {
        if (bitmap != null && imageCache != null) {
            synchronized (imageCache) {
                imageCache.put(request, bitmap);
            }
        }
    }

    public void deliverToUIThread(final ImageRequest request, final Bitmap bitmap) {
        ImageView imageView = request.getImageView();
        if (imageView == null) { return; }

        imageView.post(new Runnable() {
            @Override
            public void run() {
                updateImageView(request, bitmap);
            }
        });
    }

    private void updateImageView(ImageRequest request, Bitmap bitmap) {
        final ImageView imageView = request.getImageView();
        final String imageUrl = request.getImageUrl();
        if (bitmap != null && imageView.getTag().equals(imageUrl)) {
            imageView.setImageBitmap(bitmap);
        }

        if (bitmap == null && hasLoadFailPlaceHoder(request.displayConfig)) {
            imageView.setImageResource(request.displayConfig.loadingFailImageId);
        }

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


    private boolean hasLoadingPlaceHolder(DisplayConfig config) {
        return config != null && config.loadingImageId > 0;
    }

    private boolean hasLoadFailPlaceHoder(DisplayConfig config) {
        return config != null && config.loadingFailImageId > 0;
    }
}
