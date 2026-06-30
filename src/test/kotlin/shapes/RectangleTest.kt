package shapes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotSame

class RectangleTest {
    @Test
    fun `valid rectangle can be created from two opposite corner points`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(5.0, 8.0))

        assertEquals(24.0, rectangle.getArea())
    }

    @Test
    fun `getPoint1 and getPoint2 return expected coordinates`() {
        val rectangle = Rectangle(Point(1.5, 2.5), Point(6.5, 8.5))

        val point1 = rectangle.getPoint1()
        val point2 = rectangle.getPoint2()

        assertEquals(1.5, point1.getX())
        assertEquals(2.5, point1.getY())
        assertEquals(6.5, point2.getX())
        assertEquals(8.5, point2.getY())
    }

    @Test
    fun `returned points are copies that do not mutate the rectangle`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(5.0, 8.0))

        val point1 = rectangle.getPoint1()
        val point2 = rectangle.getPoint2()

        assertNotSame(point1, rectangle.getPoint1())
        assertNotSame(point2, rectangle.getPoint2())

        point1.move(100.0, 100.0)
        point2.move(-100.0, -100.0)

        assertEquals(1.0, rectangle.getPoint1().getX())
        assertEquals(2.0, rectangle.getPoint1().getY())
        assertEquals(5.0, rectangle.getPoint2().getX())
        assertEquals(8.0, rectangle.getPoint2().getY())
    }

    @Test
    fun `getArea returns correct area`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(5.0, 8.0))

        assertEquals(24.0, rectangle.getArea())
    }

    @Test
    fun `move moves both points`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(5.0, 8.0))

        rectangle.move(3.0, -1.0)

        assertEquals(4.0, rectangle.getPoint1().getX())
        assertEquals(1.0, rectangle.getPoint1().getY())
        assertEquals(8.0, rectangle.getPoint2().getX())
        assertEquals(7.0, rectangle.getPoint2().getY())
    }

    @Test
    fun `moving rectangle does not change area`() {
        val rectangle = Rectangle(Point(1.0, 2.0), Point(5.0, 8.0))
        val originalArea = rectangle.getArea()

        rectangle.move(-10.0, 15.0)

        assertEquals(originalArea, rectangle.getArea())
    }

    @Test
    fun `rectangle with zero width throws IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(2.0, 1.0), Point(2.0, 5.0))
        }
    }

    @Test
    fun `rectangle with zero height throws IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Rectangle(Point(1.0, 3.0), Point(5.0, 3.0))
        }
    }
}
