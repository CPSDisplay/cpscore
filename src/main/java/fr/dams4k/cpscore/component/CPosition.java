package fr.dams4k.cpscore.component;

public class CPosition {
    public int x = 0;
    public int y = 0;
    public float size = 1f;

    public CPosition(int x, int y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public String toString() {
        return "CPosition{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                '}';
    }
}
