package ScreenClasses;

import processing.core.PApplet;

public class ScreenManager {
    
    PApplet p;
    Screen currentScreen;

    public ScreenManager(PApplet p) {
        this.p = p;

        currentScreen = new Menu(this);
    }

    public void run(){
        update();
        render();
    }

    public void update() {
        currentScreen.update();
    }

    public void render() {
        currentScreen.render();
    }

}
