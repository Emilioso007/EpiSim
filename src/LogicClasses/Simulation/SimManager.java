package LogicClasses.Simulation;

import LogicClasses.ShapesClasses.AABB;

public class SimManager {

    private int frameCount = 0;

    public Agent[] agents;

    AABB simWindow;

    public SimManager(AABB simWindow) {

        agents = new Agent[SimConfig.nAgents];

        this.simWindow = simWindow;

        for (int i = 0; i < SimConfig.nAgents; i++) {
            agents[i] = new Agent(simWindow, (int) (Math.random() * simWindow.getW() + simWindow.getX()),
                    (int) (Math.random() * simWindow.getH() + simWindow.getY()),
                    5, 'S');
        }

        agents[0].setState('I');

    }

    public void run() {

        for (int i = 0; i < agents.length; i++) {
            agents[i].randomWalk();
        }

        spreadDisease();

        frameCount++;

    }

    private void spreadDisease() {

        for (int i = 0; i < agents.length; i++) {
            if (agents[i].getState() == 'I') {
                for (int j = 0; j < agents.length; j++) {
                    if (i != j) {
                        if (agents[i].overlaps(agents[j])) {
                            agents[j].setState('I');
                            agents[j].setInfected(frameCount);
                        }
                    }
                }
            }
        }

    }

}
