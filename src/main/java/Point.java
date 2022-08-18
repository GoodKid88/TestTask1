public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point to) {
            return to.x == x && to.y == y;
        }
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Koordinaatti(" + x +
                ", " + y + ")";
    }
}
