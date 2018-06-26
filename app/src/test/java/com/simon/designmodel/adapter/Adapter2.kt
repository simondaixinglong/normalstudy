package com.simon.designmodel.adapter

/**
 * Description:     适配器本身，相当于use和ps/2转接器（对象组合的方式）
 *
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 14:13
 */
class Adapter2(private var adaptee: Adaptee) : Target {

    override fun handleRequest() {
        adaptee.request()
    }
}