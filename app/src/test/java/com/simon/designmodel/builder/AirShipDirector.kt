package com.simon.designmodel.builder

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:43
 */
interface AirShipDirector {

    fun createAirShip(builder:AirShipBuilder): AirShip
}