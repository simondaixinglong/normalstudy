package com.simon.designmodel.FlyWeight

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/11 10:01
 */
interface ChessFlyWeight {

    fun setColor()
    fun getMyColor(): String
    fun display(coordinate: Coordinate)
}


/**
 * 享元类
 * 获得内部状态
 */
class ConcreteChess(private var color: String) : ChessFlyWeight {
    override fun setColor() {

    }

    override fun getMyColor(): String {
        return color
    }


    override fun display(coordinate: Coordinate) {
        println("color:$color, and coordinate is x:${coordinate.x}, y:${coordinate.y}")
    }

}


/**
 * 享元工厂类
 */
class ChessFactory {

    companion object {
        private var map = mutableMapOf<String, ChessFlyWeight>()

        fun getChess(color: String): ChessFlyWeight? {
            return if (map[color] != null) {
                map[color]
            } else {
                var chess = ConcreteChess(color)
                map[color] = chess
                return chess
            }
        }
    }

}

















