package shapes

class Point(x: Double, y: Double) {
    private var x: Double = x
    private var y: Double = y

    fun getX(): Double {
        return x
    }

    fun getY(): Double {
        return y
    }

    fun clone(): Point {
        return Point(x, y)
    }

    fun move(deltaX: Double, deltaY: Double) {
        x += deltaX
        y += deltaY

    }

}