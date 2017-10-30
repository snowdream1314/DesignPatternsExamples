package com.xxq2dream.designpatternsexamples.adapter_pattern;

/**
 * 电压转换适配器
 *
 * @author xxq
 * @date 2017/10/27
 */
public class VoltAdapter implements FiveVolt {

    Volt220 mVolt220;

    public VoltAdapter(Volt220 volt220) {
        mVolt220 = volt220;
    }

    @Override
    public int getVolt5() {
        return 5;
    }

    public int getVolt220() {
        return mVolt220.getVolt220();
    }
}
