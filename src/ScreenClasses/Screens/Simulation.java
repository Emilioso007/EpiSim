package ScreenClasses.Screens;

import LogicClasses.Simulation.SimManager;
import ScreenClasses.Screen;

public class Simulation extends Screen {

    SimManager simManager;

    public Simulation() {

        simManager = new SimManager();
    }

    public void update() {
        simManager.run();
    }

    public void render() {

    }

}
