package com.xxq2dream.designpatternsexamples.stragety_pattern;

/**
 * 计算出租车车费
 *
 * @author xxq
 * @date 2017/10/26
 */
public class TaxiStragety implements CalculateStragety {

    /**
     * 出租车车费为每公里2元
     * @param km 公里数
     * @return 出租车车费
     */
    @Override
    public int calculatePrice(int km) {
        return km * 2;
    }
}
