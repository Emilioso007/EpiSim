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

        for(int i = 0; i < simManager.agents.length; i++) {

            if(simManager.agents[i].getState() == 'S') {
                p.fill(0, 255, 0);
            } else if(simManager.agents[i].getState() == 'I') {
                p.fill(255, 0, 0);
            }

            p.ellipse(simManager.agents[i].getX(), simManager.agents[i].getY(), simManager.agents[i].getR()/2, simManager.agents[i].getR()/2);

        }

    }

}
