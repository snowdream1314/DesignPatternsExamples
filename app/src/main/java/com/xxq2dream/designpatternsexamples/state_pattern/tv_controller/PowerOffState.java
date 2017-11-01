package com.xxq2dream.designpatternsexamples.state_pattern.tv_controller;

/**
 * 关机状态，除了电源开关，其他的操作都无效，也即为空
 *
 * @author xxq
 * @date 2017/10/31
 */
public class PowerOffState implements TvState {

    @Override
    public void nextChannel() {

    }

    @Override
    public void prevChannel() {

    }

    @Override
    public void turnUp() {

    }

    @Override
    public void turnDown() {

    }
}
