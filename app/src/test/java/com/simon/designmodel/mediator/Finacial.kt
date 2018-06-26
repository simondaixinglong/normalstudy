package com.simon.designmodel.mediator

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 14:32
 */
class Finacial(private var mediator: Mediator) : Department {

    init {
        mediator.register("financial", this)
    }

    override fun selfAction() {
        println("数钱")
    }

    override fun outAction() {
        println("钱太多了，花不完")
    }
}