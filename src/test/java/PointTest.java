
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PointTest {
    private static List<Point> polygon;
    private static Point point;

    @BeforeClass
    public static void setUp() {
        polygon = new ArrayList<>();
        polygon.add(new Point(2, 1));
        polygon.add(new Point(5, 1));
        polygon.add(new Point(6, 2));
        polygon.add(new Point(6, 4));
        polygon.add(new Point(3, 3));
        point = new Point(2, 1);
    }

    public void testTestEquals() {
    }

    public void testTestToString() {
    }

//    @Test
//    public void testIsCoordinateInsidePolygon() {
//        Assertions.assertFalse(Point.isCoordinateInsidePolygon(point, polygon));
//    }
//
//    @Test
//    public void testIsCoordinateOnPolygonApex() {
//        Assertions.assertTrue(Point.isCoordinateOnPolygonApex(point, polygon));
//    }
//
//    @Test
//    public void testIsCoordinateOnPolygonSide() {
//        Assertions.assertTrue(Point.isCoordinateOnPolygonSide(point, polygon));
//    }

}