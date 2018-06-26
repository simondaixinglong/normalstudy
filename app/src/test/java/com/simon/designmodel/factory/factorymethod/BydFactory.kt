package com.simon.designmodel.factory.factorymethod

import com.simon.designmodel.factory.simpalfactory.Byd
import com.simon.designmodel.factory.simpalfactory.Car

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 11:30
 */
class BydFactory : CarFactory {
    override fun createCar(): Car {

        return Byd()
    }
}