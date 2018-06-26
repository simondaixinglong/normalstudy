package com.simon.designmodel.mediator

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 14:29
 */
class Development(private var mediator: Mediator) : Department {

    init {
        mediator.register("develop", this)
    }

    override fun selfAction() {
        println("kit")
    }

    override fun outAction() {
        println("上级汇报，没钱了，没法研发")
        mediator.command("financial")
    }
}