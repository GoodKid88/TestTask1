import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static Polygon polygon;
    private static Point point;
    private static PointStatus status;
    private static final String PATH = new File("").getAbsolutePath();

    public static void main(String[] args) throws FileNotFoundException {

        File pointFile = new File(PATH + "/src/main/resources/pisteet.txt");
        File polygonFile = new File(PATH + "/src/main/resources/polygoni.txt");
        File resultFile = new File(PATH + "/src/main/resources/selvitys.txt");

        polygon = new Polygon(FileHandler.readPolygonFile(polygonFile));
        point = FileHandler.readPointFile(pointFile);

        status = polygon.checkPointLocation(point);

        FileHandler.writeResult(point, status, resultFile);
    }
}

