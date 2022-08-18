import java.util.List;

public class Polygon {
    public static List<Point> polygonPoints;

    public Polygon(List<Point> polygon_points) {
        polygonPoints = polygon_points;
    }

    public PointStatus checkPointLocation(Point point) {
        if (isCoordinateInsidePolygon(point))
            return PointStatus.INSIDE;
        else if (isCoordinateOnPolygonSide(point))
            return PointStatus.ONSIDE;
        else return PointStatus.OUTSIDE;
    }

    public boolean isCoordinateInsidePolygon(Point point) {
        boolean result = false;
        int j = polygonPoints.size() - 1;
        for (int i = 0; i < polygonPoints.size(); i++) {
            if ( (polygonPoints.get(i).y < point.y && polygonPoints.get(j).y >= point.y ||
                    polygonPoints.get(j).y < point.y && polygonPoints.get(i).y >= point.y) &&

                    (polygonPoints.get(i).x + (point.y - polygonPoints.get(i).y) /
                            (polygonPoints.get(j).y - polygonPoints.get(i).y) * (polygonPoints.get(j).x - polygonPoints.get(i).x) < point.x) )
                result = !result;
            j = i;
        }


//        for (int i = 0; i < polygonPoints.size() - 1; i++) {
//            if (checkCoordinate(polygonPoints.get(i), polygonPoints.get(i + 1), point) != 1) {
//                return !isCoordinateOnPolygonSide(point);
//            }
//        }
        return result;
    }

//    public static int checkCoordinate(Point a, Point b, Point point) {
//        long ax = a.x - point.x;
//        long ay = a.y - point.y;
//        long bx = b.x - point.x;
//        long by = b.y - point.y;
//        //Alussa tarkistetaan, onko segmentti (a,b)
//        // tiukasti säteen toisella puolella?
//        // Tässä tapauksessa risteystä ei ole.
//        if (ay * by > 0)
//            return 1;
//        //Tarkistamme tapauksen, jossa piste c on suoralla (a,b).
//        // Vastaus nolla voidaan välttää vain,
//        // jos pisteet sijaitsevat samalla puolella y-akselia.
//        int s = Long.signum(ax * by - ay * bx);
//        if (s == 0) {
//            if (ax * bx <= 0)
//                return 0;
//            return 1;
//        }
//        //koodi, jolla tarkistetaan säteen ja segmentin leikkauspiste.
//        // S:n merkki riippuu siitä, mikä piste on säteen alapuolella.
//        if (ay < 0)
//            return -s;
//        if (by < 0)
//            return s;
//        return 1;
//    }

    public static boolean isCoordinateOnPolygonApex(Point point) {
        return polygonPoints.contains(point);
    }

    public static boolean isCoordinateOnPolygonSide(Point point) {
         //Kolineaaristen vektorien tarkistus:
        //(x-x1)(y2-y1)-(y-y1)(x2-x1) = 0
        //tarkista, onko piste janalla
        //x1<= x <= x2 ja y1 <= y <= y2
        for (int i = 0; i < polygonPoints.size() - 1; i++) {
            int x = point.x;
            int y = point.y;
            int x1 = polygonPoints.get(i).x;
            int y1 = polygonPoints.get(i).y;
            int x2 = polygonPoints.get(i + 1).x;
            int y2 = polygonPoints.get(i + 1).y;
            if ((x - x1) * (y2 - y1) - (y - y1) * (x2 - x1) == 0) {
                if (x1 <= x && x <= x2 && y1 <= y && y <= y2)
                    return true;
            }
            if (isCoordinateOnPolygonApex(point))
                return true;
        }
        return false;
    }
}
