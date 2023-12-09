package LogicClasses.Simulation;

import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.Circle;
import LogicClasses.UtilitiesClasses.Color;
import processing.core.PVector;

public class Agent extends Circle {

    private AABB simWindow;

    private char state;
    private int frameInfected = -1;
    private PVector vel;
    private float angle;

    private Color color;

    public Agent(AABB simWindow, int x, int y, int r) {
        super(x, y, r);

        this.simWindow = simWindow;

        this.state = 'S';

        angle = (float) (Math.random() * Math.PI * 2);
        vel = PVector.fromAngle(angle);

        color = new Color(0, 255, 0);
    }

    public void randomWalk() {
        angle += (Math.random() * 2 - 1) * 0.5;
        vel = PVector.fromAngle(angle);
        vel.mult(SimConfig.getAgentSpeed());
        move(vel);

        if (getX() < 0) {
            setX(simWindow.getW());
        }
        if (getX() > simWindow.getW()) {
            setX(0);
        }
        if (getY() < 0) {
            setY(simWindow.getH());
        }
        if (getY() > simWindow.getH()) {
            setY(0);
        }

    }

    public void setState(char state) {
        this.state = state;

        switch (this.state) {
            case 'S':
                color = new Color(0, 255, 0);
                break;
            case 'I':
                color = new Color(255, 0, 0);
                break;
            case 'R':
                color = new Color(0, 0, 255);
                break;
        }

    }

    public void setInfected(int frameInfected) {
        this.frameInfected = frameInfected;
    }

    public char getState() {
        return state;
    }

    public int getFrameInfected() {
        return frameInfected;
    }

    public Color getColor() {
        return color;
    }

}
