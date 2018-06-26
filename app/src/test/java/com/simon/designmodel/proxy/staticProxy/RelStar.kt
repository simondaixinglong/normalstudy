package com.simon.designmodel.proxy.staticProxy

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 14:48
 */
class RelStar : Star {


    override fun confer() {
        println("real star confer")
    }

    override fun signContract() {
        println("real star signContract")

    }

    override fun bookTicket() {
        println("real star bookTicket")

    }

    override fun sing() {
        println("real star sing")
    }

    override fun collectMoney() {
        println("real star collectMoney")

    }
}