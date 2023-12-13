/*
 *
 * EpiSim - A disease simulator
 * By Emil Jørgensen, 2023
 * 
 */

/*
 * Main class of the project.
 * Has a ScreenManager that handles the different screens of the program.
 * That's it.
 */

import processing.core.*;
import LogicClasses.UtilitiesClasses.MouseHandler;
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

        MouseHandler.init(this);
    }

    public void draw() {
        background(42);
        screenManager.run();
    }

}
