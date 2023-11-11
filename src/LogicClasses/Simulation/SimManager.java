package LogicClasses.Simulation;

import LogicClasses.ShapesClasses.AABB;

public class SimManager {

    private Agent[] agents;

    private AABB simWindow;

    public SimManager(int nAgents, AABB simWindow) {

        agents = new Agent[nAgents];

        this.simWindow = simWindow;

        for (int i = 0; i < nAgents; i++) {
            agents[i] = new Agent((int) (Math.random() * 800), (int) (Math.random() * 600), 10, 'S');
        }

    }

    public void run() {

    }

}
