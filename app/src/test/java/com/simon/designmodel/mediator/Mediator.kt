package com.simon.designmodel.mediator

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 14:25
 */
interface Mediator {

    fun register(name:String, department: Department)
    fun command(name: String)
}