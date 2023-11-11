package LogicClasses.Simulation;

import LogicClasses.ShapesClasses.AABB;
import LogicClasses.ShapesClasses.Circle;
import processing.core.PConstants;
import processing.core.PVector;

public class Agent extends Circle {

    private AABB simWindow;

    private char state;
    private int frameInfected = -1;
    private PVector vel;
    private float angle;

    public Agent(AABB simWindow, int x, int y, int r, char state) {
        super(x, y, r);

        this.simWindow = simWindow;

        this.state = state;

        angle = (float) (Math.random() * Math.PI * 2);
        vel = PVector.fromAngle(angle);

    }

    public void randomWalk() {
        angle += (Math.random() * 2 - 1) * 0.1;
        vel = PVector.fromAngle(angle);
        vel.mult(2);
        move(vel);

        if (getX() < 0 + simWindow.getX()) {
            setX(simWindow.getX() + simWindow.getW());
        }
        if (getX() > simWindow.getX() + simWindow.getW()) {
            setX(0 + simWindow.getX());
        }
        if (getY() < 0 + simWindow.getY()) {
            setY(simWindow.getY() + simWindow.getH());
        }
        if (getY() > simWindow.getY() + simWindow.getH()) {
            setY(0 + simWindow.getY());
        }

    }

    public void setState(char state) {
        this.state = state;
    }

    public void setInfected(int frameInfected) {
        this.frameInfected = frameInfected;
    }

    public char getState() {
        return state;
    }

}
