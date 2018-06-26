package com.simon.designmodel.factory.abstractfactory

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:02
 */
interface Engine {

    fun start()
    fun run()

}


class LuxuryEngine : Engine {
    override fun start() {
        println("start fast")
    }

    override fun run() {
        println("run fast")
    }
}


class LowEngine : Engine {
    override fun start() {
        println("start low")
    }

    override fun run() {
        println("run low")
    }

}