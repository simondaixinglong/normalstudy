package com.simon.designmodel.bridge

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 15:39
 */
interface Brand {

    fun sale()
}


class Lenovo : Brand {
    override fun sale() {
        println("lenovo brand")
    }

}


class Dell : Brand {
    override fun sale() {
        println("dell brand")
    }

}


