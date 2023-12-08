import processing.core.*;

import ScreenClasses.*;

public class App extends PApplet {

    ScreenManager screenManager;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(1280, 720, P2D);
    }

    public void setup() {
        surface.setTitle("EpiSim");
        screenManager = new ScreenManager(this);
        background(42);
    }

    public void draw() {
        background(42); 
        screenManager.run();
    }

}
