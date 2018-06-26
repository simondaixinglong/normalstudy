package com.simon.kotlin.sigleton

import com.simon.kotlin.Weekend

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/24 15:41
 */
object DogA {

    fun dogAName()
    {
        println("dog a")
        println(Weekend.Friday.ordinal)
        println(Weekend.Friday.name)
    }
}