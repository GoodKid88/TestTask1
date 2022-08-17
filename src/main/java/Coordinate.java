import java.util.List;

public class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coordinate to) {
            return to.x == x && to.y == y;
        }
        return super.equals(o);
    }

    public static boolean isCoordinateInsidePolygon(Coordinate coordinate, List<Coordinate> list) {
        int counter = 0;
        for (Coordinate value : list) {
            if (coordinate.x > value.x)
                counter++;
            if (coordinate.y > value.y)
                counter++;
        }
        return counter % 2 == 0 && !isCoordinateOnPolygonSide(coordinate, list);
    }

    public static boolean isCoordinateOnPolygonApex(Coordinate coordinate, List<Coordinate> list) {
        return list.contains(coordinate);
    }

    public static boolean isCoordinateOnPolygonSide(Coordinate coordinate, List<Coordinate> list) {
        //(y1-y2)*x + (x2 - x1)*y + (x1y2 - x2y1) = 0
        //(x-x1)(y2-y1)-(y-y1)(x2-x1) = 0
        //x1 < x < x2 , x2 < x< x1
        for (int i = 0; i < list.size() - 1; i++) {
            int x = coordinate.x;
            int y = coordinate.y;
            int x1 = list.get(i).x;
            int y1 = list.get(i).y;
            int x2 = list.get(i + 1).x;
            int y2 = list.get(i + 1).y;
            if ((x - x1) * (y2 - y1) - (y - y1) * (x2 - x1) == 0) {
                if (x1 < x && x < x2 || x2 < x && x < x1)
                    return true;
            }
            if (isCoordinateOnPolygonApex(coordinate, list))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Koordinaatti(" + x +
                ", " + y + ")";
    }
}
