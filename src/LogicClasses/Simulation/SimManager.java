package LogicClasses.Simulation;

import LogicClasses.ShapesClasses.AABB;

public class SimManager {

    public Agent[] agents;

    AABB simWindow;

    public SimManager(int nAgents, AABB simWindow) {

        agents = new Agent[nAgents];

        this.simWindow = simWindow;

        for (int i = 0; i < nAgents; i++) {
            agents[i] = new Agent((int) (Math.random() * simWindow.getW()), (int) (Math.random() * simWindow.getH()),
                    10, 'S');
        }

    }

    public void run() {

        for (int i = 0; i < agents.length; i++) {

            if (agents[i].getState() == 'I') {

                for (int j = i; j < agents.length; j++) {

                    if (i != j) {

                        if (agents[i].overlaps(agents[j])) {

                            agents[j].setState('I');

                        }

                    }

                }

            }

        }

    }

}
