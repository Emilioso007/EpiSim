package ScreenClasses.Screens;

import java.util.ArrayList;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.*;
import ScreenClasses.ScreenObjects.Button;;

public class Menu extends Screen {

    PApplet p;
    ScreenManager sm;

    ArrayList<Button> buttons;

    PImage logo;

    public Menu(ScreenManager sm) {
        this.sm = sm;
        this.p = sm.getP();
        buttons = new ArrayList<Button>();

        buttons.add(new Button(p.width / 2 - 100, p.height / 2 - 50, 200, 100, "Start"));
        buttons.add(new Button(p.width / 2 - 100, p.height / 2 + 50, 200, 100, "Settings"));
        buttons.add(new Button(p.width / 2 - 100, p.height / 2 + 175, 200, 100, "Exit"));

        logo = p.loadImage("Images\\Logo.png");

    }

    public void update() {
        for (Button b : buttons) {
            b.update();
        }

        if (buttons.get(0).isPressed()) {
            sm.changeScreen(new Simulation(sm));
        }

        if (buttons.get(1).isPressed()) {
            sm.changeScreen(new Settings(sm));
        }

        if (buttons.get(2).isPressed()) {
            p.exit();
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
