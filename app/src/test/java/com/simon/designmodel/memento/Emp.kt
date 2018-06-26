package com.simon.designmodel.memento

/**
 * Description:     源发器类
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/12 16:57
 */
data class Emp(var name: String, var age: Int, var salary: Double) {


    //进行备忘操作，并返回备忘录对象
    fun memento(): MementoEmp {
        return MementoEmp(this)
    }

    //进行数据恢复
    fun recovery(mementoEmp: MementoEmp) {
        this.name = mementoEmp.name
        this.age = mementoEmp.age
        this.salary = mementoEmp.salary
    }

}