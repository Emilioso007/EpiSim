package ScreenClasses.Screens;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import processing.core.*;

public class Menu extends Screen {

    PApplet p;
    ScreenManager sm;

    public Menu(ScreenManager sm) {
        this.sm = sm;
        this.p = sm.getP();
    }

    public void update() {
        if (p.mousePressed) {
            sm.changeScreen(new Simulation(sm));
        }
    }

    public void render() {
        p.background(0);
        p.fill(255);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.textSize(32);
        p.text("Click to start simulation", p.width / 2, p.height / 2);
    }

}
