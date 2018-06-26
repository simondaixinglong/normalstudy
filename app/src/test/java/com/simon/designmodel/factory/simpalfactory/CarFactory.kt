package com.simon.designmodel.factory.simpalfactory

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 11:08
 */


class CarFactory {

    companion object {
        fun create(type: String?): Car? {
            return when (type) {
                "audi" -> Audi()
                "byd" -> Byd()
                else -> null
            }
        }


        fun test(){
            println("a...")
        }
    }

}