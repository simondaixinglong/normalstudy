package com.simon.designmodel.proxy.staticProxy

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 14:49
 */
class ProxyStar(private val star: Star) : Star {
    override fun confer() {
        println("proxy confer")
    }

    override fun signContract() {
        println("proxy signContract")

    }

    override fun bookTicket() {
        println("proxy bookTicket")

    }

    override fun sing() {
        star.sing()
    }

    override fun collectMoney() {
        println("proxy collectMoney")

    }
}