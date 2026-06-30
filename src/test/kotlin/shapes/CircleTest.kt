package shapes

import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CircleTest {
    @Test
    fun `valid circle can be created with center and radius`() {
        val circle = Circle(Point(2.0, 3.0), 4.0)

        assertEquals(2.0, circle.getCenter().getX())
        assertEquals(3.0, circle.getCenter().getY())
        assertEquals(4.0, circle.getRadius())
    }

    @Test
    fun `getCenter returns expected coordinates`() {
        val circle = Circle(Point(2.5, 3.5), 4.0)

        val center = circle.getCenter()

        assertEquals(2.5, center.getX())
        assertEquals(3.5, center.getY())
    }

    @Test
    fun `getRadius returns correct radius`() {
        val circle = Circle(Point(2.0, 3.0), 4.0)

        assertEquals(4.0, circle.getRadius())
    }

    @Test
    fun `getArea returns pi times radius squared`() {
        val circle = Circle(Point(2.0, 3.0), 4.0)

        assertEquals(PI * 4.0 * 4.0, circle.getArea(), 0.000001)
    }

    @Test
    fun `move moves center`() {
        val circle = Circle(Point(2.0, 3.0), 4.0)

        circle.move(3.0, -1.0)

        assertEquals(5.0, circle.getCenter().getX())
        assertEquals(2.0, circle.getCenter().getY())
    }

    @Test
    fun `moving circle does not change area`() {
        val circle = Circle(Point(2.0, 3.0), 4.0)
        val originalArea = circle.getArea()

        circle.move(-10.0, 15.0)

        assertEquals(originalArea, circle.getArea(), 0.000001)
    }

    @Test
    fun `zero or negative radius throws IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(2.0, 3.0), 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            Circle(Point(2.0, 3.0), -4.0)
        }
    }
}
