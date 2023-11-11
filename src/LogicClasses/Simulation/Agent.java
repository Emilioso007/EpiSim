package LogicClasses.Simulation;

import LogicClasses.ShapesClasses.Circle;
import processing.core.PConstants;

public class Agent extends Circle {

    private char state;
    private int frameInfected = -1;

    public Agent(int x, int y, int r, char state) {
        super(x, y, r);

        this.state = state;
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
