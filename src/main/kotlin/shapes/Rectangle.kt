package shapes

open class Rectangle(point1: Point, point2: Point) : Shape() {

    private var point1: Point = point1.clone()
    private var point2: Point = point2.clone()

    init {
        require(this.point1.getX() != this.point2.getX()) {
            "Rectangle width cannot be zero."
        }
        require(this.point1.getY() != this.point2.getY()) {
            "Rectangle height cannot be zero."
        }
    }

    fun getPoint1(): Point {
        return point1.clone()
    }

    fun getPoint2(): Point {
        return point2.clone()
    }

    override fun getArea(): Double {
        val width = kotlin.math.abs(point1.getX() - point2.getX())
        val height = kotlin.math.abs(point1.getY() - point2.getY())
        return width * height
    }

    override fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
    }
}