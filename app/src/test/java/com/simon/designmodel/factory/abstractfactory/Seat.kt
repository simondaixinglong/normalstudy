package com.simon.designmodel.factory.abstractfactory

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:07
 */
interface Seat {

    fun massage()

}


class LuxurySeat : Seat {
    override fun massage() {
        println("massage ok")

    }

}


class LowSeat : Seat {
    override fun massage() {

        println("massage not ok")
    }

}





