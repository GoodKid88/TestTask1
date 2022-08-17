import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    private static boolean isInside;
    private static boolean isOnSide;
    private static final List<Coordinate> polygonCoordinates = new ArrayList<>();
    private static Coordinate coordinate = null;
    private static final String PATH = new File("").getAbsolutePath();

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(PATH + "/src/main/resources/pisteet.txt");
        File file2 = new File(PATH + "/src/main/resources/polygoni.txt");

       // Scanner scanner = new Scanner(file);
        coordinate = readCoordinateFile(file);

        //scanner = new Scanner(file2);
        readPolygonFile(file2);

        //scanner.close();

        isInside = Coordinate.isCoordinateInsidePolygon(coordinate, polygonCoordinates);
        isOnSide = Coordinate.isCoordinateOnPolygonSide(coordinate, polygonCoordinates);
        writeResult();
    }

    public static List<Coordinate> readPolygonFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            polygonCoordinates.add(getCoordinateFromScanner(scanner));
        }
        return polygonCoordinates;
    }

    public static Coordinate readCoordinateFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
          return getCoordinateFromScanner(scanner);
    }

    public static Coordinate getCoordinateFromScanner(Scanner scanner) {
        String line = scanner.nextLine();
        String[] stringCoordinate = line.split(" ");
        int x = Integer.parseInt(stringCoordinate[0]);
        int y = Integer.parseInt(stringCoordinate[1]);
        return new Coordinate(x, y);
    }

    public static void writeResult() throws FileNotFoundException {
        File file3 = new File(PATH + "/src/main/resources/selvitys.txt");
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
