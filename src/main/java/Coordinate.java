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

    public static boolean isCoordinateInsidePolygon(Coordinate coordinate, List<Coordinate> polygon) {
        for (int i = 0; i < polygon.size() - 1; i++) {
            if (checkCoordinate(polygon.get(i), polygon.get(i + 1), coordinate) != 1) {
                return !isCoordinateOnPolygonSide(coordinate, polygon);
            }
        }
        return false;
    }

    public static int checkCoordinate(Coordinate a, Coordinate b, Coordinate coordinate) {
        long ax = a.x - coordinate.x;
        long ay = a.y - coordinate.y;
        long bx = b.x - coordinate.x;
        long by = b.y - coordinate.y;
        //Alussa tarkistetaan, onko segmentti (a,b)
        // tiukasti säteen toisella puolella?
        // Tässä tapauksessa risteystä ei ole.
        if (ay * by > 0)
            return 1;
        //Tarkistamme tapauksen, jossa piste c on suoralla (a,b).
        // Vastaus nolla voidaan välttää vain,
        // jos pisteet sijaitsevat samalla puolella y-akselia.
        int s = Long.signum(ax * by - ay * bx);
        if (s == 0)
        {
            if (ax * bx <= 0)
                return 0;
            return 1;
        }
        //koodi, jolla tarkistetaan säteen ja segmentin leikkauspiste.
        // S:n merkki riippuu siitä, mikä piste on säteen alapuolella.
        if (ay < 0)
            return -s;
        if (by < 0)
            return s;
        return 1;
    }

    public static boolean isCoordinateOnPolygonApex(Coordinate coordinate, List<Coordinate> polygon) {
        return polygon.contains(coordinate);
    }

    public static boolean isCoordinateOnPolygonSide(Coordinate coordinate, List<Coordinate> polygon) {
        //Kolineaaristen vektorien tarkistus:
        //(x-x1)(y2-y1)-(y-y1)(x2-x1) = 0
        //tarkista, onko piste janalla
        //x1<= x <= x2 ja y1 <= y <= y2
        for (int i = 0; i < polygon.size() - 1; i++) {
            int x = coordinate.x;
            int y = coordinate.y;
            int x1 = polygon.get(i).x;
            int y1 = polygon.get(i).y;
            int x2 = polygon.get(i + 1).x;
            int y2 = polygon.get(i + 1).y;
            if ((x - x1) * (y2 - y1) - (y - y1) * (x2 - x1) == 0) {
                if (x1 <= x && x <= x2 && y1 <= y && y <= y2)
                    return true;
            }
            if (isCoordinateOnPolygonApex(coordinate, polygon))
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
