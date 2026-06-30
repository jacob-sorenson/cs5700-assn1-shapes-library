package shapes

class Circle(center: Point, radius: Double) : Ellipse(center, radius, radius) {

    fun getRadius(): Double {
        return getHorizontalRadius()
    }
}