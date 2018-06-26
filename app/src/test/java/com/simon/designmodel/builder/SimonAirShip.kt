package com.simon.designmodel.builder

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:45
 */
class SimonAirShip : AirShipBuilder {
    override fun createEngine(): String {
        return "engine"
    }

    override fun createOrbitalModule(): String {
        return "orbitalModule"
    }

    override fun createEscapeTower(): String {
        return "escapeTower"
    }
}