package com.xxq2dream.designpatternsexamples.stragety_pattern;

/**
 * 计算公交车车费
 *
 * @author xxq
 * @date 2017/10/26
 */
public class BusStragety implements CalculateStragety {

    /**
     * 十公里之内一元，超过十公里每加一元钱可以坐5公里
     * @param km 公里数
     * @return 公交车车费
     */
    @Override
    public int calculatePrice(int km) {
        //超过十公里的总距离
        int extraTotal = km - 10;

        // 超过的距离是5公里的倍数
        int extraFactor = extraTotal / 5;

        //超过的距离对5公里取余
        int fraction = extraTotal % 5;

        //价格计算
        int price = 1 + extraFactor * 1 ;

        return fraction > 0 ? ++price : price;
    }
}
