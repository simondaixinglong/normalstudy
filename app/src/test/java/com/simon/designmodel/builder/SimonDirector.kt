package com.simon.designmodel.builder

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:47
 */
class SimonDirector : AirShipDirector {
    override fun createAirShip(builder: AirShipBuilder): AirShip {

        var airShip = AirShip()
        airShip.engine = builder.createEngine()
        airShip.orbitalModule = builder.createOrbitalModule()
        return airShip
//        return AirShip(builder.createEngine(), builder.createOrbitalModule(), builder.createEscapeTower())
    }
}