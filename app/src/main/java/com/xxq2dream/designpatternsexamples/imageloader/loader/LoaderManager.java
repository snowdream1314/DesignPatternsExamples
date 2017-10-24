package com.xxq2dream.designpatternsexamples.imageloader.loader;

import java.util.HashMap;
import java.util.Map;

/**
 * Description : 加载控制类
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class LoaderManager {

    private Map<String, Loader> loaderMap = new HashMap<String, Loader>();

    private static LoaderManager mLoaderManager = null;
    private LoaderManager () {}

    public static LoaderManager getInstance() {
        if (mLoaderManager == null) {
            synchronized (LoaderManager.class) {
                if (mLoaderManager == null) {
                    mLoaderManager = new LoaderManager();
                }
            }
        }
        return mLoaderManager;

    }

    public Loader getLoader() {
        return new UrlLoader();
    }
}
