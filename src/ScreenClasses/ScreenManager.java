package ScreenClasses;

import ScreenClasses.Screens.Menu;
import processing.core.PApplet;

public class ScreenManager {

    private PApplet p;
    public Screen currentScreen;

    public ScreenManager(PApplet p) {
        this.p = p;

        currentScreen = new Menu(this);

    }

    public void run() {
        update();
        render();
    }

    public void update() {
        currentScreen.update();
    }

    public void render() {
        currentScreen.render();

        p.fill(255);
        p.textSize(16);
        p.textAlign(PApplet.RIGHT, PApplet.TOP);
        p.text("FPS: " + (int) p.frameRate, p.width, 0);
    }

    public PApplet getP() {
        return p;
    }

    public void changeScreen(Screen screen) {
        currentScreen = screen;
    }

}
