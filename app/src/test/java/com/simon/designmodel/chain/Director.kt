package com.simon.designmodel.chain

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 11:10
 */
class Director(private var dirName: String) : Leader(dirName) {

    override fun handleRequest(leaveRequest: LeaveRequest) {
        if (leaveRequest.leaveDay < 3) {
            println("director ok")
        } else {
            if (nextLeader != null) {
                nextLeader?.handleRequest(leaveRequest)
            }else{
                println("null")
            }
        }
    }
}