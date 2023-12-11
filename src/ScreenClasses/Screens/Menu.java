package ScreenClasses.Screens;

import java.util.ArrayList;

import processing.core.*;

import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button;;

public class Menu extends Screen {

    ArrayList<Button> buttons;

    PImage logo;

    public Menu(ScreenManager sm) {
        super(sm);
        buttons = new ArrayList<Button>();

        buttons.add(new Button(p.width / 2 - 100, p.height / 2 - 50, 200, 100, "Start", "startButton"));
        buttons.add(new Button(p.width / 2 - 100, p.height / 2 + 50, 200, 100, "Settings", "settingsButton"));
        buttons.add(new Button(p.width / 2 - 100, p.height / 2 + 175, 200, 100, "Exit", "exitButton"));

        logo = p.loadImage("Images\\Logo.png");

    }

    public void update() {
        for (Button b : buttons) {
            b.update();
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isPressed()) {
                switch (buttons.get(i).getKey()) {
                    
                    case "startButton":
                        sm.changeScreen(new Simulation(sm));
                        break;

                    case "settingsButton":
                        sm.changeScreen(new Settings(sm));
                        break;

                    case "exitButton":
                        p.exit();
                        break;

                    default:
                        break;

                }
            }
        }

    }

    public void render() {

        p.background(42);

        p.imageMode(PConstants.CENTER);
        p.image(logo, p.width / 2, p.height / 2 - 200);

        for (Button b : buttons) {
            b.render(p);
        }

    }

}
