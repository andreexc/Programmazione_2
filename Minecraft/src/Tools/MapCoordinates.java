package Tools;

public class MapCoordinates {

    public static final int ROWS = 5;
    public static final int COLS = 10;
    private int x;
    private int y;

    public MapCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isInbound() {
        if (x < 0 || y < 0) return false;
        if (x >= ROWS || y >= COLS) return false;
        return true;
    }

    @Override
    public String toString(){
        return "("+this.x+"-"+this.y+")";
    }
}
