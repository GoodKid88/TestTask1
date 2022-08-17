import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1Test extends TestCase {

    @Test
    public void testReadPolygonFile() throws FileNotFoundException {
        File file = new File("src/test/resources/testPolygonCoordinates.txt");
        List<Coordinate> expected = new ArrayList<>();
        expected.add(new Coordinate(3, 3));
        expected.add(new Coordinate(5, 5));
        expected.add(new Coordinate(6, 5));
        expected.add(new Coordinate(5, 6));
        Assertions.assertEquals(expected, Task1.readPolygonFile(file));
    }

    @Test
    public void testReadCoordinateFile() throws FileNotFoundException {
        File file = new File("src/test/resources/testCoordinate.txt");
        Assertions.assertEquals(new Coordinate(5, 5), Task1.readCoordinateFile(file));
    }

    @Test
    public void testGetCoordinateFromScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/test/resources/testCoordinate.txt"));
        Assertions.assertEquals(new Coordinate(5, 5), Task1.getCoordinateFromScanner(scanner));
    }

    public void testWriteResult() {
    }
}