package LogicClasses.ShapesClasses;

public class AABB {

    private int x, y, w, h;

    public AABB(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public boolean contains(int x, int y) {
        return x >= this.x && x <= this.x + this.w && y >= this.y && y <= this.y + this.h;
    }

    public boolean intersects(AABB other) {
        return this.x + this.w > other.getX() && this.x < other.getX() + other.getW() && this.y + this.h > other.getY()
                && this.y < other.getY() + other.getH();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

}
