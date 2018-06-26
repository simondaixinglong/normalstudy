package com.simon.designmodel.observer

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 15:51
 */
open class Subject {

    var observerList = mutableListOf<Observer>()

    fun register(observer: Observer) {
        observerList.add(observer)
    }

    fun remove(observer: Observer) {
        observerList.remove(observer)
    }

    fun notifyAllObserver() {
        observerList.forEach { it.update(this) }
    }

}