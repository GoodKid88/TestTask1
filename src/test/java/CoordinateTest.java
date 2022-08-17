import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CoordinateTest extends TestCase {
    List<Coordinate> polygon = new ArrayList<>();

    @Test
    public void testIsCoordinateInsidePolygon() {
        polygon.add(new Coordinate(3, 3));
        polygon.add(new Coordinate(5, 5));
        polygon.add(new Coordinate(6, 5));
        Assertions.assertFalse(Coordinate.isCoordinateInsidePolygon(new Coordinate(10, 1), polygon));
    }

    @Test
    public void testIsCoordinateOnPolygonApex() {
        polygon.add(new Coordinate(2, 3));
        polygon.add(new Coordinate(3, 5));
        polygon.add(new Coordinate(7, 5));
        Assertions.assertFalse(Coordinate.isCoordinateOnPolygonApex(new Coordinate(12, 5), polygon));
    }

    @Test
    public void testIsCoordinateOnPolygonSide() {
        polygon.add(new Coordinate(3, 3));
        polygon.add(new Coordinate(5, 5));
        polygon.add(new Coordinate(6, 5));
        Assertions.assertFalse(Coordinate.isCoordinateOnPolygonSide(new Coordinate(2, 1), polygon));
    }

}