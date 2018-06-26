package com.simon.designmodel.builder

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 14:41
 */
interface AirShipBuilder {

    fun createEngine():String
    fun createOrbitalModule():String
    fun createEscapeTower():String
}