/*
 * The simulation screen, aka. the heart of the program.
 * It is responsible for rendering the simulation, as well as the graph.
 */

package ScreenClasses.Screens;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

import LogicClasses.Simulation.SimManager;
import LogicClasses.Simulation.Graph.GraphLine;
import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.Color;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button;

public class Simulation extends Screen {

    private SimManager simManager;

    private AABB simWindow, graphWindow;

    private PGraphics simGraphics, graphGraphics;

    private ArrayList<Button> buttons;

    public Simulation(ScreenManager sm) {
        super(sm);

        this.simWindow = new AABB(640, 60, 600, 600);
        this.graphWindow = new AABB(60, 60, 520, 300);

        simManager = new SimManager(simWindow);

        simGraphics = p.createGraphics((int) simWindow.getW(), (int) simWindow.getH(), PConstants.P2D);
        graphGraphics = p.createGraphics((int) graphWindow.getW(), (int) graphWindow.getH(), PConstants.P2D);

        buttons = new ArrayList<Button>();

        buttons.add(new Button(50, p.height / 2 + 250, 200, 100, "Menu", "menuButton"));
        buttons.add(new Button(50, p.height / 2 + 150, 200, 100, "Reset", "resetButton"));
        buttons.add(new Button(50, p.height / 2 + 50, 200, 100, "Pause", "pauseButton"));

    }

    public void update() {

        simManager.run();

        if (p.mousePressed && this.graphWindow.contains(p.mouseX, p.mouseY)) {
            this.graphWindow.setX(this.graphWindow.getX() + p.mouseX - p.pmouseX);
            this.graphWindow.setY(this.graphWindow.getY() + p.mouseY - p.pmouseY);
        } else if (p.mousePressed && this.simWindow.contains(p.mouseX, p.mouseY)) {
            this.simWindow.setX(this.simWindow.getX() + p.mouseX - p.pmouseX);
            this.simWindow.setY(this.simWindow.getY() + p.mouseY - p.pmouseY);
        }

        for (Button b : buttons) {
            b.update();
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isPressed()) {
                switch (buttons.get(i).getKey()) {

                    case "menuButton":
                        sm.changeScreen(new Menu(sm));
                        break;

                    case "resetButton":
                        simManager = new SimManager(simWindow);
                        break;

                    case "pauseButton":
                        simManager.togglePause();
                        break;

                    default:
                        break;

                }
            }
        }

    }

    public void render() {

        p.background(42);

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

        p.imageMode(PConstants.CORNER);
        p.image(simGraphics, simWindow.getX(), simWindow.getY());
        p.image(graphGraphics, graphWindow.getX(), graphWindow.getY());

        for (Button b : buttons) {
            b.render(p);
        }

    }

    public void renderSimGraphics() {
        simGraphics.beginDraw();

        simGraphics.background(42);

        simGraphics.noStroke();
        simGraphics.ellipseMode(PConstants.RADIUS);
        for (int i = 0; i < simManager.totalAgents(); i++) {

            Color tempC = simManager.getAgent(i).getColor();

            simGraphics.fill(tempC.getR(), tempC.getG(), tempC.getB());

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

        graphGraphics.background(42, 128);

        for (int i = 0; i < simManager.graphManager.getLines().size(); i++) {

            GraphLine line = simManager.graphManager.getLines().get(i);

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
