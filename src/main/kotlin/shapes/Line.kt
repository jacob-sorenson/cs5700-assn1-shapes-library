
package shapes

import kotlin.math.sqrt

class Line(point1: Point, point2: Point) {
    private var point1: Point = point1.clone()
    private var point2: Point = point2.clone()

    init {
        require(this.point1.getX() != this.point2.getX() && this.point1.getY() != this.point2.getY()) {
            "Line points cannot be the same"
        }

    }

    fun getPoint1(): Point {
        return point1.clone()
    }

    fun getPoint2(): Point {
        return point2.clone()
    }

    fun getSlope(): Double {
        val diffY = point2.getY() - point1.getY()
        val diffX = point2.getX() - point1.getX()
        if (diffX <= 0.0){
            return 0.0
        } else {
            return diffY / diffX
        }

    }

    fun getLength(): Double {
        val diffX = point1.getX() - point2.getX()
        val diffY = point1.getY() - point2.getY()
        val squaredX = diffX * diffX
        val squaredY = diffY * diffY
        return sqrt(squaredX + squaredY)
    }

    fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
    }





}