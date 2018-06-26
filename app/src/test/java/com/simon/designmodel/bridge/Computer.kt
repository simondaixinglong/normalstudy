package com.simon.designmodel.bridge

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/6 15:41
 */
open class Computer(private val brand: Brand) {
    open fun sale() {
        brand.sale()
    }
}


class Desktop(brand: Brand) : Computer(brand) {

    override fun sale() {
        super.sale()
        println("desktop computer")
    }

}


class Laptop(brand: Brand) : Computer(brand) {
    override fun sale() {
        super.sale()
        println("laptop computer")
    }
}
