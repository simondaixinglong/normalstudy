package com.simon.decimal

import org.junit.Test
import java.math.BigDecimal

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/11/20 09:35
 */
class DecimalTest {

    @Test
    fun halfEven(){

        var str = "98.465068"
        var str1 = "98.465068"

        BigDecimal("98.465068")
//
        var big1 = BigDecimal(str).setScale(2, BigDecimal.ROUND_HALF_EVEN)
        var big2 = BigDecimal(str1).setScale(2, BigDecimal.ROUND_HALF_EVEN)
//
        println(big1)
        println(big2)

//        var a = 100f
//        var b = 360f
//
//        println(b/a)

    }

}