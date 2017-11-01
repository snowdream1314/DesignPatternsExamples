package com.xxq2dream.designpatternsexamples.state_pattern.tv_controller;

/**
 * 电源开关操作
 *
 * @author xxq
 * @date 2017/10/31
 */
public interface PowerController {
    /**
     * 电源打开状态
     */
    public void powerOn();

    /**
     * 电源关闭状态
     */
    public void powerOff();
}
