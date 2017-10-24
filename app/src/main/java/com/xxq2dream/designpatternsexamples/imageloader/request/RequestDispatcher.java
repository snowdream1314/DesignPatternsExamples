package com.xxq2dream.designpatternsexamples.imageloader.request;

import com.xxq2dream.designpatternsexamples.imageloader.loader.LoaderManager;

import java.util.concurrent.BlockingQueue;

/**
 * Description : 执行网络请求的线程
 * <p>
 * Author      : Created by xxq on 2017/10/24.
 */


public class RequestDispatcher extends Thread{

    private BlockingQueue<ImageRequest> requestQueues;

    public RequestDispatcher (BlockingQueue<ImageRequest> requestQueues){
        this.requestQueues = requestQueues;
    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted()) {
                ImageRequest request = requestQueues.take();
                if (request.isCanceled) {
                    continue;
                }

                LoaderManager.getInstance().getLoader().loadImage(request);
            }


        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
