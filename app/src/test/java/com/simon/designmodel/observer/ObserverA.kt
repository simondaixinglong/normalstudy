package com.simon.designmodel.observer

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 15:58
 */
class ObserverA : Observer {

    var myState: Int = 0

    override fun update(subject: Subject) {
        myState = (subject as ConcreteSubject).state
        println(myState)
    }
}