package com.simon.designmodel.factory.simpalfactory

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 11:08
 */


class CarFactory1 {

    companion object {

        fun createAudi(): Car {
            return Audi()
        }

        fun ceateByd(): Car {
            return Byd()
        }
    }

}