package com.simon.designmodel.chain

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 11:16
 */
class Manager(private var managerName: String) : Leader(managerName) {

    override fun handleRequest(leaveRequest: LeaveRequest) {

        if (leaveRequest.leaveDay < 10) {
            println("manager ok")
        } else {
            if (nextLeader != null) {
                nextLeader?.handleRequest(leaveRequest)
            }
        }
    }
}