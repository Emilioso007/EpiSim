package ScreenClasses.Screens;

import LogicClasses.ShapesClasses.AABB;
import LogicClasses.Simulation.SimManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PConstants;

public class Simulation extends Screen {

    PApplet p;
    ScreenManager sm;

    SimManager simManager;

    private int nAgents;

    private AABB simWindow;

    public Simulation(ScreenManager sm, int nAgents) {

        this.sm = sm;
        this.p = sm.getP();

        this.simWindow = new AABB(20, 20, 200, 200);

        this.nAgents = nAgents;
        simManager = new SimManager(simWindow);

    }

    public void update() {
        simManager.run();
    }

    public void render() {

        p.rectMode(PConstants.CORNER);
        p.noFill();
        p.stroke(255);
        p.strokeWeight(2);
        p.rect(simWindow.getX(), simWindow.getY(), simWindow.getW(), simWindow.getH());

        p.noStroke();
        p.ellipseMode(PConstants.RADIUS);
        for (int i = 0; i < simManager.agents.length; i++) {

            if (simManager.agents[i].getState() == 'S') {
                p.fill(0, 255, 0);
            } else if (simManager.agents[i].getState() == 'I') {
                p.fill(255, 0, 0);
            }

            p.ellipse(simManager.agents[i].getX(), simManager.agents[i].getY(), simManager.agents[i].getR(),
                    simManager.agents[i].getR());

        }

    }

}
