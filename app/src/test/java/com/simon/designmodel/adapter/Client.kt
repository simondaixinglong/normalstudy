package com.simon.designmodel.adapter

import org.junit.Test

/**
 * Description:     相当于笔记本,只有usb接口
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 14:12
 */
class Client {

    private fun computerPrint(target: Target) {
        target.handleRequest()
    }


    @Test
    fun test() {
        var t = Adapter()
        computerPrint(t)
    }

}