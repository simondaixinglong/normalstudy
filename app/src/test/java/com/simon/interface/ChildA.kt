package com.simon.`interface`

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/9/13 15:59
 */
class ChildA :InterfaceA , InterfaceB{

    override var b: String
        get() = "interfaceB"
        set(value) {}

    override var a: String = "interface test"
        get() = "interfaceA"
        set(value) {
            field = value
        }

    override fun foo() {
        super<InterfaceA>.foo()
        super<InterfaceB>.foo()
    }

}