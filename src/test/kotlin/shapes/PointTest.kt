package shapes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

class PointTest {
    @Test
    fun `point can be created with x and y values`() {
        val point = Point(2.5, -4.0)

        assertEquals(2.5, point.getX())
        assertEquals(-4.0, point.getY())
    }

    @Test
    fun `getX returns the x value`() {
        val point = Point(7.25, 3.0)

        assertEquals(7.25, point.getX())
    }

    @Test
    fun `getY returns the y value`() {
        val point = Point(7.25, 3.0)

        assertEquals(3.0, point.getY())
    }

    @Test
    fun `clone returns a new point with the same coordinates`() {
        val point = Point(1.0, 2.0)

        val clone = point.clone()

        assertNotSame(point, clone)
        assertEquals(point.getX(), clone.getX())
        assertEquals(point.getY(), clone.getY())
    }

    @Test
    fun `cloned point is independent from original point`() {
        val point = Point(1.0, 2.0)
        val clone = point.clone()

        clone.move(10.0, 20.0)

        assertEquals(1.0, point.getX())
        assertEquals(2.0, point.getY())
        assertEquals(11.0, clone.getX())
        assertEquals(22.0, clone.getY())
    }

    @Test
    fun `move updates x and y values`() {
        val point = Point(3.0, 4.0)

        point.move(-1.5, 2.25)

        assertEquals(1.5, point.getX())
        assertEquals(6.25, point.getY())
    }
}
