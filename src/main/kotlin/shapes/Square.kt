package shapes


class Square(point1: Point, point2: Point) : Rectangle(point1, point2) {

    init {
        val horizontalSide = kotlin.math.abs(point1.getX() - point2.getX())
        val verticalSide = kotlin.math.abs(point1.getY() - point2.getY())
        require(horizontalSide == verticalSide) {
            "Both sides should be the same length to make a square."
        }
    }
}