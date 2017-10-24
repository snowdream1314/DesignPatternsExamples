package com.xxq2dream.designpatternsexamples.imageloader.queue;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;
import com.xxq2dream.designpatternsexamples.imageloader.request.RequestDispatcher;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Description : 请求队列
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public final class RequestQueue {
    //请求队列
    private BlockingQueue<ImageRequest> mRequestQueue = new PriorityBlockingQueue<>();

    //默认请求核心数
    public static int DEFAULT_CORE_NUMS = Runtime.getRuntime().availableProcessors() + 1;

    //执行网络请求的线程
    private RequestDispatcher[] mDispatchers = null;

    //执行网络请求的线程的数量
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

}
