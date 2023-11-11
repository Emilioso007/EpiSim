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
    }

    public PApplet getP() {
        return p;
    }

    public void changeScreen(Screen screen) {
        currentScreen = screen;
    }

}
