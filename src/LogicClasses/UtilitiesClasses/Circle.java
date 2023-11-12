package LogicClasses.UtilitiesClasses;

import processing.core.PVector;

public class Circle {

    private PVector pos;
    private float x, y, r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Circle(PVector pos, int r) {
        this.pos = pos;
        this.x = pos.x;
        this.y = pos.y;
        this.r = r;
    }

    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
        this.pos = new PVector(this.x, this.y);
    }

    public void move(PVector dpos) {
        this.x += dpos.x;
        this.y += dpos.y;
        this.pos = new PVector(this.x, this.y);
    }

    public boolean contains(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) < this.r;
    }

    public boolean overlaps(Circle other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2)) < this.r
                + other.getR();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public PVector getPos() {
        return pos;
    }

    public void setX(float x) {
        this.x = x;
        this.pos = new PVector(this.x, this.y);
    }

    public void setY(float y) {
        this.y = y;
        this.pos = new PVector(this.x, this.y);
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setPos(PVector pos) {
        this.pos = pos;
        this.x = pos.x;
        this.y = pos.y;
    }

}
