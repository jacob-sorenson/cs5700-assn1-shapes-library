package shapes

open class Ellipse(point1: Point, horizontalRadius: Double, verticalRadius: Double): Shape() {
    private val point1: Point = point1.clone()
    private val horizontalRadius: Double = horizontalRadius
    private val verticalRadius: Double = verticalRadius

    init{
        require(horizontalRadius > 0.0 && verticalRadius > 0.0){
            "Horizontal and Vertical Radii must be greater than zero."
        }
    }

    fun getCenter(): Point {
        return point1.clone()
    }

    fun getHorizontalRadius(): Double {
        return horizontalRadius
    }

    fun getVerticalRadius(): Double {
        return verticalRadius
    }

    override fun getArea(): Double {
        return kotlin.math.PI * getHorizontalRadius() * getVerticalRadius()
    }

    override fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
    }

}