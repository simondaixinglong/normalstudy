package com.simon.designmodel.factory.abstractfactory

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:13
 */
interface CarFactory {

    fun createEngine(): Engine
    fun createSeat(): Seat
    fun createTyre(): Tyre

}


class LuxuryCar : CarFactory {
    override fun createEngine(): Engine {
        return LuxuryEngine()
    }

    override fun createSeat(): Seat {
        return LuxurySeat()
    }

    override fun createTyre(): Tyre {
        return LuxuryTyre()
    }


}


class LowCar : CarFactory {
    override fun createEngine(): Engine {
        return LowEngine()
    }

    override fun createSeat(): Seat {
        return LowSeat()
    }

    override fun createTyre(): Tyre {
        return LowTyre()
    }

}


