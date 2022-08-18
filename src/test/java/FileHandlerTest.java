import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandlerTest {
    private static List<Point> polygon;

    @Test
    public void testReadPolygonFile() throws FileNotFoundException {
        polygon = new ArrayList<>();
        polygon.add(new Point(3, 3));
        polygon.add(new Point(5, 5));
        polygon.add(new Point(6, 5));
        polygon.add(new Point(5, 6));
        File file = new File("src/test/resources/testPolygoni.txt");
        Assertions.assertEquals(polygon, FileHandler.readPolygonFile(file));
    }

    @Test
    public void testReadCoordinateFile() throws FileNotFoundException {
        File file = new File("src/test/resources/testPisteet.txt");
        Assertions.assertEquals(new Point(5, 5), FileHandler.readPointFile(file));
    }

    @Test
    public void testGetCoordinateFromScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/testPisteet.txt"));
        Assertions.assertNotEquals(new Point(5, 1), FileHandler.getPointFromScanner(scanner));
    }

    public void testTestReadPolygonFile() {
    }

    public void testReadPointFile() {
    }

    public void testGetPointFromScanner() {
    }

    public void testWriteResult() {
    }
}