package ScreenClasses.Screens;

import java.util.ArrayList;

import LogicClasses.Simulation.SimConfig;
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

        buttons.add(new Button(100, 100, 35, 35, "+"));
        buttons.add(new Button(100, 135, 35, 35, "-"));
        buttons.add(new Button(p.width - 200, p.height / 2 + 30, 100, 60, "back"));

        buttons.add(new Button(100, 50, 50, 35, "1"));
        buttons.add(new Button(150, 50, 50, 35, "10"));
        buttons.add(new Button(200, 50, 50, 35, "50"));
        buttons.add(new Button(250, 50, 50, 35, "100"));

        buttons.add(new Button(100, 200, 35, 35, "+"));
        buttons.add(new Button(100, 235, 35, 35, "-"));

    }

    public void update() {
        for (Button b : buttons) {
            b.update();
        }

        int temp = -1;

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isPressed()) {
                temp = i;
            }
        }

        switch (temp) {
            case 0: // add increment to nAgents
                SimConfig.setProperty("nAgents", String.valueOf(SimConfig.getNAgents() + increment));
                break;
            case 1: // subtract increment from nAgents
                SimConfig.setProperty("nAgents", String.valueOf(SimConfig.getNAgents() - increment));
                if (SimConfig.getNAgents() < 0) {
                    SimConfig.setProperty("nAgents", "0");
                }
                break;
            case 2: // back
                screenManager.changeScreen(new Menu(screenManager));
                break;
            case 3: // set increment to 1
                increment = 1;
                break;
            case 4: // set increment to 10
                increment = 10;
                break;
            case 5: // set increment to 50
                increment = 50;
                break;
            case 6: // set increment to 100
                increment = 100;
                break;
            case 7: // add increment to agentRadius
                SimConfig.setProperty("agentRadius", String.valueOf(SimConfig.getAgentRadius() + increment));
                break;
            case 8: // subtract increment from agentRadius
                SimConfig.setProperty("agentRadius", String.valueOf(SimConfig.getAgentRadius() - increment));
                if (SimConfig.getAgentRadius() < 1) {
                    SimConfig.setProperty("agentRadius", "1");
                }
                break;
            default:
                break;
        }

    }

    public void render() {

        p.background(42);

        for (Button b : buttons) {
            b.render(this.screenManager.getP());
        }

        p.fill(255);
        p.textSize(16);
        p.textAlign(PConstants.LEFT, PConstants.CENTER);
        p.text("   nAgents: " + SimConfig.getNAgents(), buttons.get(0).getX() + buttons.get(0).getW(),
                buttons.get(0).getY() + buttons.get(0).getH());
        p.text("   agentRadius: " + SimConfig.getAgentRadius(), buttons.get(7).getX() + buttons.get(7).getW(),
                buttons.get(7).getY() + buttons.get(7).getH());

    }

}
