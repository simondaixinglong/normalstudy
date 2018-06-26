package com.simon.designmodel.state

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 10:52
 */
class StateContext {

    var state: State? = null
        set(value) {
            field = value
            state!!.handle()
        }
}