import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CoordinateTest {
    private static List<Coordinate> polygon;
    private static Coordinate coordinate;

    @BeforeClass
    public static void setUp() {
        polygon = new ArrayList<>();
        polygon.add(new Coordinate(2, 1));
        polygon.add(new Coordinate(5, 1));
        polygon.add(new Coordinate(6, 2));
        polygon.add(new Coordinate(6, 4));
        polygon.add(new Coordinate(3, 3));
        coordinate = new Coordinate(2, 1);
    }

    @Test
    public void testIsCoordinateInsidePolygon() {
        Assertions.assertFalse(Coordinate.isCoordinateInsidePolygon(coordinate, polygon));
    }

    @Test
    public void testIsCoordinateOnPolygonApex() {
        Assertions.assertTrue(Coordinate.isCoordinateOnPolygonApex(coordinate, polygon));
    }

    @Test
    public void testIsCoordinateOnPolygonSide() {
        Assertions.assertTrue(Coordinate.isCoordinateOnPolygonSide(coordinate, polygon));
    }

}