package com.simon.designmodel.adapter

/**
 * Description:     适配器本身，相当于use和ps/2转接器（类适配方式）
 *                  使用的是继承的方式，继承只能单继承
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 14:13
 */
class Adapter :Target, Adaptee() {

    override fun handleRequest() {
        super.request()
    }
}