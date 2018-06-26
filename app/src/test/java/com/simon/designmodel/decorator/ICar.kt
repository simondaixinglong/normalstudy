package com.simon.designmodel.decorator

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/9 17:39
 */
interface ICar {
    fun move()
}

//具体构建角色（真实对象）
class Car : ICar {
    override fun move() {
        println("陆地上跑")
    }

}


//装饰角色，容器
open class SuperCar(private val iCar: ICar) : ICar {

    override fun move() {
        iCar.move()
    }

}


class FlySuperCar(iCar: ICar) : SuperCar(iCar) {

    private fun fly() {
        println("fly")
    }

    override fun move() {
        super.move()
        fly()
    }
}


class WaterCar(iCar: ICar) : SuperCar(iCar) {

    private fun swim() {
        println("swim")
    }

    override fun move() {
        super.move()
        swim()
    }
}




















