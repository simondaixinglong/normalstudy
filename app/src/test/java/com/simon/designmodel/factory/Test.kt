package com.simon.designmodel.factory

import com.simon.designmodel.builder.SimonAirShip
import com.simon.designmodel.builder.SimonDirector
import com.simon.designmodel.factory.abstractfactory.LuxuryCar
import com.simon.designmodel.factory.factorymethod.AudiFactory
import com.simon.designmodel.factory.factorymethod.BydFactory
import com.simon.designmodel.factory.simpalfactory.Car
import com.simon.designmodel.factory.simpalfactory.CarFactory
import org.junit.Test

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 10:50
 */
class Test {


    @Test
    fun test() {
        CarFactory.create("byd")?.run()
        CarFactory.test()
    }

    @Test
    fun factoryMethod() {

        var audi: Car = AudiFactory().createCar()
        var byd: Car = BydFactory().createCar()

        audi.run()
        byd.run()

    }


    @Test
    fun abstractFactory(){

        var car = LuxuryCar()
        var engine = car.createEngine()
        engine.start()
        engine.run()
    }


    @Test
    fun testBuilder(){

        var airDirector = SimonDirector().createAirShip(SimonAirShip())
        println(airDirector.engine)


    }

}














