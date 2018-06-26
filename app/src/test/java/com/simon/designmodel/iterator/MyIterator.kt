package com.simon.designmodel.iterator

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 14:10
 */
interface MyIterator {

    fun first()
    fun next()
    fun hasNext(): Boolean

    fun isFirst()
    fun isLast()

    fun getCurrentObj(): Any
}