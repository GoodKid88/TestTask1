
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private static Scanner scanner;

    public static List<Point> readPolygonFile(File file) {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa polygoni.txt ei löytynyt");
        }
        List<Point> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(getPointFromScanner(scanner));
        }
        return list;
    }

    public static Point readPointFile(File file) {
        try {
            return getPointFromScanner(new Scanner(file));
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa pisteet.txt ei löytynyt");
        }
        return null;
    }

    public static Point getPointFromScanner(Scanner scanner) {
        String line = scanner.nextLine();
        String[] stringCoordinate = line.split(" ");
        int x = Integer.parseInt(stringCoordinate[0]);
        int y = Integer.parseInt(stringCoordinate[1]);
        return new Point(x, y);
    }

    public static void writeResult(Point point, PointStatus status, File file) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa sevitys.txt ei löytynyt");
        }

        switch (status) {
            case INSIDE -> printWriter.println(point + " on polygonin sisäpuolella");
            case ONSIDE -> printWriter.println(point + " on polygonin reunaviivan päällä");
            case OUTSIDE -> printWriter.println(point + " on polygonin ulkopuolella");
        }
        printWriter.close();
        scanner.close();
    }
}
