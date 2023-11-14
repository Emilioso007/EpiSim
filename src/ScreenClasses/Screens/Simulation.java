package ScreenClasses.Screens;

import LogicClasses.Simulation.SimManager;
import LogicClasses.Simulation.Graph.GraphLine;
import LogicClasses.Simulation.Graph.GraphManager;
import LogicClasses.UtilitiesClasses.AABB;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class Simulation extends Screen {

    private PApplet p;
    private ScreenManager sm;

    private SimManager simManager;

    private GraphManager graphManager;

    private AABB simWindow, graphWindow;

    private PGraphics simGraphics, graphGraphics;

    public Simulation(ScreenManager sm) {

        this.sm = sm;
        this.p = this.sm.getP();

        this.simWindow = new AABB(640, 60, 600, 600);
        this.graphWindow = new AABB(60, 60, 520, 300);

        graphManager = new GraphManager(graphWindow);
        simManager = new SimManager(simWindow, graphManager);

        simGraphics = p.createGraphics((int) simWindow.getW(), (int) simWindow.getH(), PConstants.P2D);
        graphGraphics = p.createGraphics((int) graphWindow.getW(), (int) graphWindow.getH(), PConstants.P2D);

    }

    public void update() {

        simManager.run();
        graphManager.run();
        
        if (p.mousePressed && this.graphWindow.contains(p.mouseX, p.mouseY)) {
            this.graphWindow.setX(this.graphWindow.getX() + p.mouseX - p.pmouseX);
            this.graphWindow.setY(this.graphWindow.getY() + p.mouseY - p.pmouseY);
        } else if (p.mousePressed && this.simWindow.contains(p.mouseX, p.mouseY)) {
            this.simWindow.setX(this.simWindow.getX() + p.mouseX - p.pmouseX);
            this.simWindow.setY(this.simWindow.getY() + p.mouseY - p.pmouseY);
        }

    }

    public void render() {

        renderSimGraphics();

        if (simManager.agentsInfected() > 0) {
            renderGraphGraphics();
        } else {
            graphGraphics.beginDraw();
            graphGraphics.fill(20, 50);
            graphGraphics.textAlign(PConstants.CENTER, PConstants.CENTER);
            graphGraphics.textSize(32);
            graphGraphics.text("done", graphWindow.getW() / 2, graphWindow.getH() / 2);
            graphGraphics.endDraw();
        }

        p.image(simGraphics, simWindow.getX(), simWindow.getY());
        p.image(graphGraphics, graphWindow.getX(), graphWindow.getY());

    }

    public void renderSimGraphics() {
        simGraphics.beginDraw();

        simGraphics.background(42);

        simGraphics.noStroke();
        simGraphics.ellipseMode(PConstants.RADIUS);
        for (int i = 0; i < simManager.totalAgents(); i++) {

            switch (simManager.getAgent(i).getState()) {
                case 'S':
                    simGraphics.fill(0, 255, 0);
                    break;
                case 'I':
                    simGraphics.fill(255, 0, 0);
                    break;
                case 'R':
                    simGraphics.fill(0, 0, 255);
                    break;
                default:
                    break;
            }

            simGraphics.ellipse(simManager.getAgent(i).getX(), simManager.getAgent(i).getY(),
                    simManager.getAgent(i).getR(),
                    simManager.getAgent(i).getR());

        }

        simGraphics.rectMode(PConstants.CORNER);
        simGraphics.noFill();
        simGraphics.stroke(255);
        simGraphics.strokeWeight(2);
        simGraphics.rect(0, 0, simWindow.getW(), simWindow.getH());

        simGraphics.endDraw();

    }

    public void renderGraphGraphics() {

        graphGraphics.beginDraw();

        graphGraphics.background(42);

        for (int i = 0; i < graphManager.getLines().size(); i++) {

            GraphLine line = graphManager.getLines().get(i);

            graphGraphics.stroke(line.getColor().getR(), line.getColor().getG(), line.getColor().getB());
            graphGraphics.strokeWeight(5);

            graphGraphics.beginShape();

            if (line.getLength() == 1) {
                graphGraphics.vertex(0,
                        PApplet.map(line.getDataAtIndex(0), 0, simManager.totalAgents(), graphWindow.getH() - 5, 5));
            } else {
                for (int j = 0; j < line.getLength(); j++) {

                    float x = PApplet.map(j, 0, line.getLength() - 1, 0, graphWindow.getW());
                    float y = PApplet.map(line.getDataAtIndex(j), 0, simManager.totalAgents(), graphWindow.getH() - 5,
                            5);

                    graphGraphics.vertex(x, y);

                }
            }
            graphGraphics.endShape();

        }

        graphGraphics.rectMode(PConstants.CORNER);
        graphGraphics.noFill();
        graphGraphics.stroke(255);
        graphGraphics.strokeWeight(2);
        graphGraphics.rect(0, 0, graphWindow.getW(), graphWindow.getH());

        graphGraphics.endDraw();

    }

}
