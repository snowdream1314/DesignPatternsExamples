package com.xxq2dream.designpatternsexamples.state_pattern.tv_controller;

/**
 * description
 *
 * @author xxq
 * @date 2017/10/31
 */
public class TvController implements PowerController {
    TvState tvState;

    public void setTvState(TvState mTvState) {
        this.tvState = mTvState;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("关机啦");
    }

    public void nextChannel() {
        tvState.nextChannel();
    }

    public void prevChannel() {
        tvState.prevChannel();
    }

    public void turnUp() {
        tvState.turnUp();
    }

    public void turnDown() {
        tvState.turnDown();
    }
}
