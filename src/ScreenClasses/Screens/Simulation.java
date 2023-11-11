package ScreenClasses.Screens;

import LogicClasses.ShapesClasses.AABB;
import LogicClasses.Simulation.SimManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;

public class Simulation extends Screen {

    PApplet p;
    ScreenManager sm;

    SimManager simManager;

    private int nAgents;

    private AABB simWindow;

    public Simulation(ScreenManager sm, int nAgents) {

        this.sm = sm;
        this.p = sm.getP();

        this.simWindow = new AABB(0, 0, p.width, p.height);

        this.nAgents = nAgents;
        simManager = new SimManager(this.nAgents, simWindow);

    }

    public void update() {
        simManager.run();
    }

    public void render() {

    }

}
