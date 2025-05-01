package Lez9_eq_cp;

public class NamedPoint implements Comparable<NamedPoint> {

    public String name;
    public int x;
    public int y;

    public NamedPoint() {
        this.name = "A";
        this.x = 0;
        this.y = 0;
    }

    public NamedPoint(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.x + ", " + this.y + ")";
    }

    // questo criterio di comparamento viene definito ordinamento
    // naturale per Point essendo che è il compareTo
    @Override
    public int compareTo(NamedPoint p) {
        // il mio algoritmo di comparamento prevede di
        // comparare le y e se sono uguali comparo per x

        int delta = this.y - p.y;
        if (delta == 0) {
            delta = this.x - p.x;
        }
        return delta;
    }
}
