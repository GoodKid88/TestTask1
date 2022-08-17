
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckCoordinate {
    private static boolean isInside;
    private static boolean isOnSide;
    private static final List<Coordinate> polygonCoordinates = new ArrayList<>();
    private static Coordinate coordinate = null;
    private static Scanner scanner;
    private static final String PATH = new File("").getAbsolutePath();

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(PATH + "/src/main/resources/pisteet.txt");
        File file2 = new File(PATH + "/src/main/resources/polygoni.txt");
        File file3 = new File(PATH + "/src/main/resources/selvitys.txt");

        coordinate = readCoordinateFile(file);
        readPolygonFile(file2);

        isInside = Coordinate.isCoordinateInsidePolygon(coordinate, polygonCoordinates);
        isOnSide = Coordinate.isCoordinateOnPolygonSide(coordinate, polygonCoordinates);
        writeResult(file3);
        scanner.close();
    }

    public static List<Coordinate> readPolygonFile(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            polygonCoordinates.add(getCoordinateFromScanner(scanner));
        }
        return polygonCoordinates;
    }

    public static Coordinate readCoordinateFile(File file) throws FileNotFoundException {
        return getCoordinateFromScanner(new Scanner(file));
    }

    public static Coordinate getCoordinateFromScanner(Scanner scanner) {
        String line = scanner.nextLine();
        String[] stringCoordinate = line.split(" ");
        int x = Integer.parseInt(stringCoordinate[0]);
        int y = Integer.parseInt(stringCoordinate[1]);
        return new Coordinate(x, y);
    }

    public static void writeResult(File file3) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file3);
        if (isInside) {
            printWriter.println(coordinate + " on polygonin sisäpuolella");
        } else if (isOnSide) {
            printWriter.println(coordinate + " on polygonin reunaviivan päällä");
        } else {
            printWriter.println(coordinate + " on polygonin ulkopuolella");
        }
        printWriter.close();
    }
}
