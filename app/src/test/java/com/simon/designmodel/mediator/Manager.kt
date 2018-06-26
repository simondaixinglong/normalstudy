package com.simon.designmodel.mediator

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 14:35
 */
class Manager : Mediator {

    var map = mutableMapOf<String, Department>()

    override fun register(name: String, department: Department) {
        map[name] = department
    }

    override fun command(name: String) {
        map[name]!!.selfAction()
    }
}