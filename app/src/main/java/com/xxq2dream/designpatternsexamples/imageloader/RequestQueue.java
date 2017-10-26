package com.xxq2dream.designpatternsexamples.imageloader;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description : 请求队列
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public final class RequestQueue {
    /**
     * 请求队列
     */
    private BlockingQueue<ImageRequest> mRequestQueue = new PriorityBlockingQueue<>();

    /**
     * 默认请求核心数
     */
    public static int DEFAULT_CORE_NUMS = Runtime.getRuntime().availableProcessors() + 1;

    /**
     * 执行网络请求的线程
     */
    private RequestDispatcher[] mDispatchers = null;

    /**
     * 请求的序列号生成器
     */
    private AtomicInteger mSerialNumGenerator = new AtomicInteger(0);

    /**
     * 执行网络请求的线程的数量
     */
    private int mDispatcherNums = DEFAULT_CORE_NUMS;

    public RequestQueue() {
        this(DEFAULT_CORE_NUMS);
    }

    public RequestQueue (int count) {
        this.mDispatcherNums = count;
    }

    public void start() {
        stop();
        startDisPatchers();
    }

    public void addRequest(ImageRequest request) {
        if (!mRequestQueue.contains(request)) {
            request.serialNum = generateSerialNum();
            mRequestQueue.add(request);
        }
    }

    private void startDisPatchers() {
        mDispatchers = new RequestDispatcher[mDispatcherNums];
        for (int i=0; i<mDispatchers.length; i++) {
            mDispatchers[i] = new RequestDispatcher(mRequestQueue);
            mDispatchers[i].start();
        }
    }

    public void stop() {
        if (mDispatchers != null && mDispatchers.length > 0) {
            for (int i=0; i<mDispatchers.length; i++) {
                mDispatchers[i].interrupt();
            }
        }
    }

    public void clear() {
        mRequestQueue.clear();
    }

    /**
     * @return 序列号
     */
    private int generateSerialNum() {
        return mSerialNumGenerator.incrementAndGet();
    }

}
