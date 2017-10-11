package com.xxq2dream.designpatternsexamples.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Description : 关闭工具类
 * <p>
 * Author      : Created by xxq on 2017/10/6.
 */


public final class CloseUtils {

    private CloseUtils() { }

    /**
     * 关闭Closeable对象
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
