package com.xxq2dream.designpatternsexamples.imageloader.policy;

import com.xxq2dream.designpatternsexamples.imageloader.request.ImageRequest;

/**
 * 加载策略接口
 *
 * @author xxq
 * @date 2017/10/26
 */
public interface LoadPolicy {

    /**
     * 对比请求的序列号
     *
     * @param request1 请求1
     * @param request2 请求2
     * @return 请求的序列号差值
     */
    public int compare(ImageRequest request1, ImageRequest request2);
}
