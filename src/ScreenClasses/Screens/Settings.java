package ScreenClasses.Screens;

import java.util.ArrayList;

import LogicClasses.Simulation.SimConfig;
import LogicClasses.Simulation.SimManager;
import LogicClasses.Simulation.Graph.GraphManager;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button;
import processing.core.PApplet;
import processing.core.PConstants;

public class Settings extends Screen {

    ArrayList<Button> buttons;

    ScreenManager screenManager;

    PApplet p;

    private int increment = 1;

    public Settings(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.p = this.screenManager.getP();
        buttons = new ArrayList<Button>();

        buttons.add(new Button(p.width - 200, p.height / 2 + 30, 100, 60, "back", "backButton"));

        buttons.add(new Button(100, 50, 50, 35, "1", "increment1"));
        buttons.add(new Button(150, 50, 50, 35, "10", "increment10"));
        buttons.add(new Button(200, 50, 50, 35, "50", "increment50"));
        buttons.add(new Button(250, 50, 50, 35, "100", "increment100"));

        buttons.add(new Button(100, 100, 35, 35, "+", "addAgentButton"));
        buttons.add(new Button(100, 135, 35, 35, "-", "subtractAgentButton"));
        buttons.add(new Button(100, 200, 35, 35, "+", "addRadiusButton"));
        buttons.add(new Button(100, 235, 35, 35, "-", "subtractRadiusButton"));
        buttons.add(new Button(100, 300, 35, 35, "+", "addSpeedButton"));
        buttons.add(new Button(100, 335, 35, 35, "-", "subtractSpeedButton"));
        buttons.add(new Button(100, 400, 35, 35, "+", "addRecoveryButton"));
        buttons.add(new Button(100, 435, 35, 35, "-", "subtractRecoveryButton"));

    }

    public void update() {
        for (Button b : buttons) {
            b.update();
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isPressed()) {
                switch (buttons.get(i).getKey()) {

                    case "backButton":
                        screenManager.changeScreen(new Menu(screenManager));
                        break;

                    case "increment1":
                        increment = 1;
                        break;

                    case "increment10":
                        increment = 10;
                        break;

                    case "increment50":
                        increment = 50;
                        break;

                    case "increment100":
                        increment = 100;
                        break;

                    case "addAgentButton":
                        SimConfig.setProperty("nAgents", String.valueOf(SimConfig.getNAgents() + increment));
                        break;

                    case "subtractAgentButton":
                        SimConfig.setProperty("nAgents", String.valueOf(SimConfig.getNAgents() - increment));
                        if (SimConfig.getNAgents() < 1) {
                            SimConfig.setProperty("nAgents", "1");
                        }
                        break;

                    case "addRadiusButton":
                        SimConfig.setProperty("agentRadius", String.valueOf(SimConfig.getAgentRadius() + increment));
                        break;

                    case "subtractRadiusButton":
                        SimConfig.setProperty("agentRadius", String.valueOf(SimConfig.getAgentRadius() - increment));
                        if (SimConfig.getAgentRadius() < 1) {
                            SimConfig.setProperty("agentRadius", "1");
                        }
                        break;

                    case "addSpeedButton":
                        SimConfig.setProperty("agentSpeed", String.valueOf(SimConfig.getAgentSpeed() + increment));
                        break;

                    case "subtractSpeedButton":
                        SimConfig.setProperty("agentSpeed", String.valueOf(SimConfig.getAgentSpeed() - increment));
                        if (SimConfig.getAgentSpeed() < 1) {
                            SimConfig.setProperty("agentSpeed", "1");
                        }
                        break;

                    case "addRecoveryButton":
                        SimConfig.setProperty("recoveryTime", String.valueOf(SimConfig.getRecoveryTime() + increment));
                        break;

                    case "subtractRecoveryButton":
                        SimConfig.setProperty("recoveryTime", String.valueOf(SimConfig.getRecoveryTime() - increment));
                        if (SimConfig.getRecoveryTime() < 1) {
                            SimConfig.setProperty("recoveryTime", "1");
                        }
                        break;

                    default:
                        break;

                }
            }
        }

    }

    public void render() {

        p.background(42);

        for (Button b : buttons) {
            b.render(this.screenManager.getP());
        }

        p.fill(255);
        p.textSize(24);

        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text("Settings", p.width / 2, 50);

        p.textSize(16);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);

        p.text("   increment: " + increment, buttons.get(4).getX() + buttons.get(4).getW(),
                buttons.get(4).getY() + buttons.get(4).getH() / 2);

        p.text("   nAgents: " + SimConfig.getNAgents(), buttons.get(5).getX() + buttons.get(5).getW(),
                buttons.get(5).getY() + buttons.get(5).getH());
        p.text("   agentRadius: " + SimConfig.getAgentRadius(), buttons.get(7).getX() + buttons.get(7).getW(),
                buttons.get(7).getY() + buttons.get(7).getH());
        p.text("   agentSpeed: " + SimConfig.getAgentSpeed(), buttons.get(9).getX() + buttons.get(9).getW(),
                buttons.get(9).getY() + buttons.get(9).getH());
        p.text("   recoveryTime: " + SimConfig.getRecoveryTime(), buttons.get(11).getX() + buttons.get(11).getW(),
                buttons.get(11).getY() + buttons.get(11).getH());

    }

}
