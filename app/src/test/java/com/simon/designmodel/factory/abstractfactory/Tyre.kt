package com.simon.designmodel.factory.abstractfactory

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:11
 */
interface Tyre {

    fun revolve()
}


class LuxuryTyre : Tyre {
    override fun revolve() {
        println("good")

    }

}


class LowTyre : Tyre {
    override fun revolve() {
        println("bad")

    }

}

