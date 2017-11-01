package com.xxq2dream.designpatternsexamples.state_pattern.tv_controller;

/**
 * 开机状态
 *
 * @author xxq
 * @date 2017/10/31
 */
public class PowerOnState implements TvState {

    @Override
    public void nextChannel() {
        System.out.println("下一个节目");
    }

    @Override
    public void prevChannel() {
        System.out.println("上一个节目");
    }

    @Override
    public void turnUp() {
        System.out.println("增大音量");
    }

    @Override
    public void turnDown() {
        System.out.println("减小音量");
    }
}
