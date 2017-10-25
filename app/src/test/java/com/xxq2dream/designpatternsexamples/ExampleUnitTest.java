package com.xxq2dream.designpatternsexamples;

import com.xxq2dream.designpatternsexamples.imageloader.ImageLoader;
import com.xxq2dream.designpatternsexamples.imageloader.cache.MemoryCache;
import com.xxq2dream.designpatternsexamples.imageloader.config.ImageLoaderConfig;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        ImageLoaderConfig config = new ImageLoaderConfig.Builder()
                .setImageCache(new MemoryCache())
                .setThreadCount(2)
                .create();
        ImageLoader.getInstance().init(config);
    }
}