package com.xxq2dream.designpatternsexamples.state_pattern.tv_controller;

import org.junit.Test;

/**
 * description
 *
 * @author xxq
 * @date 2017/10/31
 */
public class TvControllerTest {

    @Test
    public void test() {
        TvController tvController = new TvController();
        //开机
        tvController.powerOn();
        //下一频道
        tvController.nextChannel();
        //调高音量
        tvController.turnUp();
        //关机
        tvController.powerOff();
        //调高音量
        tvController.turnUp();

    }

}