package LogicClasses.Simulation;

import LogicClasses.ShapesClasses.Circle;

public class Agent extends Circle {

    private char state;

    public Agent(int x, int y, int r, char state) {
        super(x, y, r);

        this.state = state;
    }

    public void setState(char state) {
        this.state = state;
    }

}
