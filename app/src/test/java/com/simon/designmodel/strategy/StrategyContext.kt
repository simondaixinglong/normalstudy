package com.simon.designmodel.strategy

/**
 * Description:     负责和具体的策略交互
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 10:10
 */
class StrategyContext(private var strategy: Strategy) {

    fun getPrince(originPrice: Double) {
        strategy.getPrice(originPrice)
    }

}