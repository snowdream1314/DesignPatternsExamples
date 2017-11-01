package com.xxq2dream.designpatternsexamples.state_pattern.tv_controller;

/**
 * 定义电视操作
 *
 * @author xxq
 * @date 2017/10/31
 */
public interface TvState {
    /**
     * 下一个频道
     */
    public void nextChannel();

    /**
     * 上一个频道
     */
    public void prevChannel();

    /**
     * 调大音量
     */
    public void turnUp();

    /**
     * 调小音量
     */
    public void turnDown();

}
