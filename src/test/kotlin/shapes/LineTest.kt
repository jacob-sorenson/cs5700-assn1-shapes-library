package shapes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotSame

class LineTest {
    @Test
    fun `valid line can be created from two different points`() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))

        assertEquals(0.0, line.getPoint1().getX())
        assertEquals(0.0, line.getPoint1().getY())
        assertEquals(3.0, line.getPoint2().getX())
        assertEquals(4.0, line.getPoint2().getY())
    }

    @Test
    fun `getPoint1 and getPoint2 return points with correct coordinates`() {
        val line = Line(Point(1.5, 2.5), Point(6.5, 8.5))

        val point1 = line.getPoint1()
        val point2 = line.getPoint2()

        assertEquals(1.5, point1.getX())
        assertEquals(2.5, point1.getY())
        assertEquals(6.5, point2.getX())
        assertEquals(8.5, point2.getY())
    }

    @Test
    fun `getPoint1 and getPoint2 return copies that do not mutate the line`() {
        val line = Line(Point(1.0, 2.0), Point(4.0, 6.0))

        val point1 = line.getPoint1()
        val point2 = line.getPoint2()

        assertNotSame(point1, line.getPoint1())
        assertNotSame(point2, line.getPoint2())

        point1.move(100.0, 100.0)
        point2.move(-100.0, -100.0)

        assertEquals(1.0, line.getPoint1().getX())
        assertEquals(2.0, line.getPoint1().getY())
        assertEquals(4.0, line.getPoint2().getX())
        assertEquals(6.0, line.getPoint2().getY())
    }

    @Test
    fun `creating zero length line throws IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Line(Point(2.0, 3.0), Point(2.0, 3.0))
        }
    }

    @Test
    fun `getLength returns distance for 3 4 5 triangle`() {
        val line = Line(Point(0.0, 0.0), Point(3.0, 4.0))

        assertEquals(5.0, line.getLength())
    }

    @Test
    fun `move moves both endpoints`() {
        val line = Line(Point(1.0, 2.0), Point(4.0, 6.0))

        line.move(3.0, -1.0)

        assertEquals(4.0, line.getPoint1().getX())
        assertEquals(1.0, line.getPoint1().getY())
        assertEquals(7.0, line.getPoint2().getX())
        assertEquals(5.0, line.getPoint2().getY())
    }

    @Test
    fun `moving line does not change length`() {
        val line = Line(Point(1.0, 2.0), Point(4.0, 6.0))
        val originalLength = line.getLength()

        line.move(-10.0, 15.0)

        assertEquals(originalLength, line.getLength())
    }

    @Test
    fun `slope works for normal non vertical line`() {
        val line = Line(Point(1.0, 2.0), Point(5.0, 10.0))

        assertEquals(2.0, line.getSlope())
    }
}
