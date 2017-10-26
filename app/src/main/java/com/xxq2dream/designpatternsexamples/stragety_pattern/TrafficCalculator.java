package com.xxq2dream.designpatternsexamples.stragety_pattern;

/**
 * 计算交通费
 *
 * @author xxq
 * @date 2017/10/26
 */
public class TrafficCalculator {
    public static void main(String[] args) {
        TrafficCalculator trafficCalculator = new TrafficCalculator();
        trafficCalculator.setCalculateStragety(new BusStragety());
        trafficCalculator.calculatePrice(66);
    }

    CalculateStragety mCalculateStragety;

    /**
     * 根据需要注入相应的策略
     *
     * @param calculateStragety 注入的策略
     */
    public void setCalculateStragety(CalculateStragety calculateStragety) {
        mCalculateStragety = calculateStragety;
    }

    /**
     * 把具体的计算委托给注入的策略
     *
     * @param km 公里数
     * @return 车费
     */
    private int calculatePrice(int km) {
       return mCalculateStragety.calculatePrice(km);
    }
}
