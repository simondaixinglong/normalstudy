package com.simon.designmodel.command

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 15:16
 */
interface Command {

    //这个方法比较简单
    //实际开发中可以定义多个方法
    fun execute()

}


class ConcreteCommand(private var receiver: Receiver) : Command {

    override fun execute() {

        //执行前后可以做相关的工作
        receiver.acion()

    }

}





