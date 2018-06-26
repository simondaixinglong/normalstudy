package com.simon.designmodel.command

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 15:19
 */
class Invoker(private var command: Command) {

    //command 也可以是一个容器，进行批处理,数据库的底层就是类似的操作

    fun call() {

        //前后可有执行相关操作
        command.execute()
    }

}