package com.simon.designmodel.observer

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 15:56
 */
class ConcreteSubject : Subject() {

    var state: Int = 0
        set(value) {
            field = value
            this.notifyAllObserver()
        }
}