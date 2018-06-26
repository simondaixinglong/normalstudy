package com.simon.designmodel.factory.factorymethod

import com.simon.designmodel.factory.simpalfactory.Audi
import com.simon.designmodel.factory.simpalfactory.Car

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 11:29
 */
class AudiFactory : CarFactory {
    override fun createCar(): Car {
        return Audi()

    }
}