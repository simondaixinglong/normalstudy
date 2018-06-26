package com.simon.designmodel.memento

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 16:59
 */
data class MementoEmp(var name: String, var age: Int, var salary: Double) {

    constructor(emp: Emp) : this(emp.name, emp.age, emp.salary)

}