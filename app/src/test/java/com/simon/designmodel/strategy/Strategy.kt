package com.simon.designmodel.strategy

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 10:07
 */
interface Strategy {
    fun getPrice(originPrice: Double): Double
}


class NewCustomerFew : Strategy {

    override fun getPrice(originPrice: Double): Double {
        println("no discount")
        return originPrice
    }

}


class NewCustomerBig : Strategy {
    override fun getPrice(originPrice: Double): Double {
        return originPrice * 0.9
    }


}

class OldCustomerBig : Strategy {
    override fun getPrice(originPrice: Double): Double {
        return originPrice * 0.8
    }

}


