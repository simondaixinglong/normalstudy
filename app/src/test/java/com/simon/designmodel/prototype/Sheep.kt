package com.simon.designmodel.prototype

import java.util.*

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 16:26
 */
data class Sheep(var name: String, var birthday: Date) : Cloneable {

    override fun clone(): Any {

        var any = super.clone()
        //添加如下代码实现深度克隆
        var sheep = any as Sheep
        //把属性也进行克隆
        sheep.birthday = sheep.birthday.clone() as Date

        return any
    }

}