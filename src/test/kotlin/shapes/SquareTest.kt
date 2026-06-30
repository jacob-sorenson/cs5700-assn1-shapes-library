package shapes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SquareTest {
    @Test
    fun `valid square can be created`() {
        val square = Square(Point(1.0, 2.0), Point(5.0, 6.0))

        assertEquals(16.0, square.getArea())
    }

    @Test
    fun `getArea returns correct area`() {
        val square = Square(Point(1.0, 2.0), Point(5.0, 6.0))

        assertEquals(16.0, square.getArea())
    }

    @Test
    fun `move moves both defining points`() {
        val square = Square(Point(1.0, 2.0), Point(5.0, 6.0))

        square.move(3.0, -1.0)

        assertEquals(4.0, square.getPoint1().getX())
        assertEquals(1.0, square.getPoint1().getY())
        assertEquals(8.0, square.getPoint2().getX())
        assertEquals(5.0, square.getPoint2().getY())
    }

    @Test
    fun `moving square does not change area`() {
        val square = Square(Point(1.0, 2.0), Point(5.0, 6.0))
        val originalArea = square.getArea()

        square.move(-10.0, 15.0)

        assertEquals(originalArea, square.getArea())
    }

    @Test
    fun `non square rectangle shape passed into constructor throws IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Square(Point(1.0, 2.0), Point(5.0, 8.0))
        }
    }

    @Test
    fun `zero width is rejected`() {
        assertFailsWith<IllegalArgumentException> {
            Square(Point(2.0, 1.0), Point(2.0, 5.0))
        }
    }

    @Test
    fun `zero height is rejected`() {
        assertFailsWith<IllegalArgumentException> {
            Square(Point(1.0, 3.0), Point(5.0, 3.0))
        }
    }
}
