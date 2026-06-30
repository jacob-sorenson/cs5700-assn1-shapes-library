package shapes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotSame

class TriangleTest {
    @Test
    fun `valid triangle can be created from three non collinear points`() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))

        assertEquals(6.0, triangle.getArea())
    }

    @Test
    fun `getPoint1 getPoint2 and getPoint3 return expected coordinates`() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))

        val point1 = triangle.getPoint1()
        val point2 = triangle.getPoint2()
        val point3 = triangle.getPoint3()

        assertEquals(0.0, point1.getX())
        assertEquals(0.0, point1.getY())
        assertEquals(4.0, point2.getX())
        assertEquals(0.0, point2.getY())
        assertEquals(0.0, point3.getX())
        assertEquals(3.0, point3.getY())
    }

    @Test
    fun `returned points are copies that do not mutate the triangle`() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))

        val point1 = triangle.getPoint1()
        val point2 = triangle.getPoint2()
        val point3 = triangle.getPoint3()

        assertNotSame(point1, triangle.getPoint1())
        assertNotSame(point2, triangle.getPoint2())
        assertNotSame(point3, triangle.getPoint3())

        point1.move(100.0, 100.0)
        point2.move(100.0, 100.0)
        point3.move(100.0, 100.0)

        assertEquals(0.0, triangle.getPoint1().getX())
        assertEquals(0.0, triangle.getPoint1().getY())
        assertEquals(4.0, triangle.getPoint2().getX())
        assertEquals(0.0, triangle.getPoint2().getY())
        assertEquals(0.0, triangle.getPoint3().getX())
        assertEquals(3.0, triangle.getPoint3().getY())
    }

    @Test
    fun `getArea returns correct area`() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))

        assertEquals(6.0, triangle.getArea())
    }

    @Test
    fun `move moves all three points`() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))

        triangle.move(3.0, -1.0)

        assertEquals(3.0, triangle.getPoint1().getX())
        assertEquals(-1.0, triangle.getPoint1().getY())
        assertEquals(7.0, triangle.getPoint2().getX())
        assertEquals(-1.0, triangle.getPoint2().getY())
        assertEquals(3.0, triangle.getPoint3().getX())
        assertEquals(2.0, triangle.getPoint3().getY())
    }

    @Test
    fun `moving triangle does not change area`() {
        val triangle = Triangle(Point(0.0, 0.0), Point(4.0, 0.0), Point(0.0, 3.0))
        val originalArea = triangle.getArea()

        triangle.move(-10.0, 15.0)

        assertEquals(originalArea, triangle.getArea())
    }

    @Test
    fun `three collinear points throw IllegalArgumentException`() {
        assertFailsWith<IllegalArgumentException> {
            Triangle(Point(0.0, 0.0), Point(2.0, 2.0), Point(4.0, 4.0))
        }
    }
}
