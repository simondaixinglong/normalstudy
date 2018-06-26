package com.simon.designmodel.chain

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 11:04
 */
abstract class Leader(var name: String, var nextLeader: Leader?) {

    constructor(name: String) : this(name, null)

//    lateinit var nextLeader: Leader
//
//    fun setLeader(leader: Leader){
//        this.nextLeader = leader
//    }

    abstract fun handleRequest(leaveRequest: LeaveRequest)


}