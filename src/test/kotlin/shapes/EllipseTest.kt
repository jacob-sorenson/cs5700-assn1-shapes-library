package shapes

import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotSame

class EllipseTest {
    @Test
    fun `valid ellipse can be created with center and radii`() {
        val ellipse = Ellipse(Point(2.0, 3.0), 4.0, 5.0)

        assertEquals(2.0, ellipse.getCenter().getX())
        assertEquals(3.0, ellipse.getCenter().getY())
        assertEquals(4.0, ellipse.getHorizontalRadius())
        assertEquals(5.0, ellipse.getVerticalRadius())
    }

    @Test
    fun `getCenter returns expected coordinates`() {
        val ellipse = Ellipse(Point(2.5, 3.5), 4.0, 5.0)

        val center = ellipse.getCenter()

        assertEquals(2.5, center.getX())
        assertEquals(3.5, center.getY())
    }

    @Test
    fun `getCenter returns a copy that does not mutate the ellipse`() {
        val ellipse = Ellipse(Point(2.0, 3.0), 4.0, 5.0)

        val center = ellipse.getCenter()

        assertNotSame(center, ellipse.getCenter())

        center.move(100.0, 100.0)

        assertEquals(2.0, ellipse.getCenter().getX())
        assertEquals(3.0, ellipse.getCenter().getY())
    }

    @Test
    fun `getHorizontalRadius and getVerticalRadius return correct values`() {
        val ellipse = Ellipse(Point(2.0, 3.0), 4.0, 5.0)

        assertEquals(4.0, ellipse.getHorizontalRadius())
        assertEquals(5.0, ellipse.getVerticalRadius())
    }

    @Test
    fun `getArea returns pi times horizontal radius times vertical radius`() {
        val ellipse = Ellipse(Point(2.0, 3.0), 4.0, 5.0)

        assertEquals(PI * 4.0 * 5.0, ellipse.getArea(), 0.000001)
    }

    @Test
    fun `move moves center`() {
        val ellipse = Ellipse(Point(2.0, 3.0), 4.0, 5.0)

        ellipse.move(3.0, -1.0)

        assertEquals(5.0, ellipse.getCenter().getX())
        assertEquals(2.0, ellipse.getCenter().getY())
    }

    @Test
    fun `moving ellipse does not change area`() {
        val ellipse = Ellipse(Point(2.0, 3.0), 4.0, 5.0)
        val originalArea = ellipse.getArea()

        ellipse.move(-10.0, 15.0)

        assertEquals(originalArea, ellipse.getArea(), 0.000001)
    }

    @Test
    fun `zero or negative radii throw IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Ellipse(Point(2.0, 3.0), 0.0, 5.0)
        }
        assertFailsWith<IllegalArgumentException> {
            Ellipse(Point(2.0, 3.0), 4.0, 0.0)
        }
        assertFailsWith<IllegalArgumentException> {
            Ellipse(Point(2.0, 3.0), -4.0, 5.0)
        }
        assertFailsWith<IllegalArgumentException> {
            Ellipse(Point(2.0, 3.0), 4.0, -5.0)
        }
    }
}
