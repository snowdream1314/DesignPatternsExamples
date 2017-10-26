package com.xxq2dream.designpatternsexamples.stragety_pattern;

/**
 * 计算价格抽象策略接口
 *
 * @author xxq
 * @date 2017/10/26
 */
public interface CalculateStragety {

    /**
     * 根据公里数计算价格
     *
     * @param km 公里数
     * @return 价格
     */
    int calculatePrice(int km);
}
