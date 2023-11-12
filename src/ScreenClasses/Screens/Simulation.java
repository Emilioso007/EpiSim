package ScreenClasses.Screens;

import LogicClasses.ShapesClasses.AABB;
import LogicClasses.Simulation.SimManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class Simulation extends Screen {

    PApplet p;
    ScreenManager sm;

    SimManager simManager;

    private AABB simWindow;

    PGraphics pg;

    public Simulation(ScreenManager sm) {

        this.sm = sm;
        this.p = sm.getP();

        this.simWindow = new AABB(20, 20, 300, 200);

        simManager = new SimManager(simWindow);

        pg = p.createGraphics((int) simWindow.getW(), (int) simWindow.getH(), PConstants.P2D);

    }

    public void update() {
        simManager.run();

        if(p.mousePressed && this.simWindow.contains(p.mouseX, p.mouseY)){
            this.simWindow.setX(this.simWindow.getX() + p.mouseX - p.pmouseX);
            this.simWindow.setY(this.simWindow.getY() + p.mouseY - p.pmouseY);
        }
    }

    public void render() {

        pg.beginDraw();

        pg.background(42);

        pg.noStroke();
        pg.ellipseMode(PConstants.RADIUS);
        for (int i = 0; i < simManager.agents.length; i++) {

            switch (simManager.agents[i].getState()) {
                case 'S':
                    pg.fill(0, 255, 0);
                    break;
                case 'I':
                    pg.fill(255, 0, 0);
                    break;
                case 'R':
                    pg.fill(0, 0, 255);
                    break;
                default:
                    break;
            }

            pg.ellipse(simManager.agents[i].getX(), simManager.agents[i].getY(), simManager.agents[i].getR(),
                    simManager.agents[i].getR());

        }

        pg.rectMode(PConstants.CORNER);
        pg.noFill();
        pg.stroke(255);
        pg.strokeWeight(2);
        pg.rect(0, 0, simWindow.getW(), simWindow.getH());

        pg.endDraw();

        p.image(pg, simWindow.getX(), simWindow.getY());

    }

}
