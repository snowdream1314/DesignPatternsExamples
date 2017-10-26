package com.xxq2dream.designpatternsexamples.imageloader.policy;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

/**
 * 顺序加载请求策略
 *
 * @author xxq
 * @date 2017/10/26
 */
public class SerialPolicy implements LoadPolicy {

    @Override
    public int compare(ImageRequest request1, ImageRequest request2) {
        return request1.serialNum - request2.serialNum;
    }
}
