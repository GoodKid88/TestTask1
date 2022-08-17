import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckCoordinateTest {
    private static List<Coordinate> polygon;

    @Test
    public void testReadPolygonFile() throws FileNotFoundException {
        polygon = new ArrayList<>();
        polygon.add(new Coordinate(3, 3));
        polygon.add(new Coordinate(5, 5));
        polygon.add(new Coordinate(6, 5));
        polygon.add(new Coordinate(5, 6));
        File file = new File("src/test/resources/testPolygoni.txt");
        Assertions.assertEquals(polygon, CheckCoordinate.readPolygonFile(file));
    }

    @Test
    public void testReadCoordinateFile() throws FileNotFoundException {
        File file = new File("src/test/resources/testPisteet.txt");
        Assertions.assertEquals(new Coordinate(5, 5), CheckCoordinate.readCoordinateFile(file));
    }

    @Test
    public void testGetCoordinateFromScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/testPisteet.txt"));
        Assertions.assertNotEquals(new Coordinate(5, 1), CheckCoordinate.getCoordinateFromScanner(scanner));
    }
}