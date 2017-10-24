package com.xxq2dream.designpatternsexamples.imageloader.loader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;
import com.xxq2dream.designpatternsexamples.utils.CloseUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class UrlLoader extends AbsLoader {

    @Override
    public Bitmap onLoadImage(ImageRequest request){
        Bitmap bitmap = null;
        String imageUrl = request.getImageUrl();
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            URL url = new URL(imageUrl);
            connection = (HttpURLConnection) url.openConnection();
            inputStream = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(inputStream);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeQuietly(inputStream);
            if (connection != null) {
                connection.disconnect();
            }
        }

        return bitmap;
    }
}
