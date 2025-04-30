package Slide_4;

public class Point3D extends Point {

    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void move(int dx, int dy, int dz) {
        super.move(dx, dy);
        this.z += dz;
    }

    public int getZ() {
        return this.z;
    }
}
