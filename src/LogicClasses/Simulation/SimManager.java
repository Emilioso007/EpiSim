package LogicClasses.Simulation;

import LogicClasses.Simulation.Graph.GraphManager;
import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.Random;

public class SimManager {

    private int frameCount = 0;

    private Agent[] agents;

    private AABB simWindow;

    private GraphManager graphManager;

    public SimManager(AABB simWindow, GraphManager graphManager) {

        agents = new Agent[SimConfig.nAgents];

        this.simWindow = simWindow;

        this.graphManager = graphManager;

        for (int i = 0; i < SimConfig.nAgents; i++) {
            agents[i] = new Agent(this.simWindow,
                    Random.Int(this.simWindow.getW()),
                    Random.Int(this.simWindow.getH()),
                    5, 'S');
        }

        agents[0].setState('I');

    }

    public void run() {

        for (int i = 0; i < agents.length; i++) {
            agents[i].randomWalk();
        }

        spreadDisease();

        checkForRecovery();

        if (frameCount % 10 == 0) {
            sendDataToGraphManager();
        }

        frameCount++;

    }

    private void spreadDisease() {

        for (int i = 0; i < agents.length; i++) {
            if (agents[i].getState() == 'I') {
                for (int j = 0; j < agents.length; j++) {
                    if (i != j && agents[j].getState() == 'S') {
                        if (agents[i].overlaps(agents[j])) {
                            agents[j].setState('I');
                            agents[j].setInfected(frameCount);
                        }
                    }
                }
            }
        }

    }

    private void checkForRecovery() {

        for (int i = 0; i < agents.length; i++) {
            if (agents[i].getState() == 'I') {
                if (frameCount - agents[i].getFrameInfected() > 300) {
                    agents[i].setState('R');
                }
            }
        }

    }

    private void sendDataToGraphManager() {

        int nS = agentsSusceptible();
        int nI = agentsInfected();
        int nR = agentsRecovered();

        graphManager.sendData(nS, 0);
        graphManager.sendData(nI, 1);
        graphManager.sendData(nR, 2);

    }

    public int agentsSusceptible() {

        int n = 0;
        for (int i = 0; i < agents.length; i++) {
            if (agents[i].getState() == 'S') {
                n++;
            }
        }
        return n;

    }

    public int agentsInfected() {
        int n = 0;
        for (int i = 0; i < agents.length; i++) {
            if (agents[i].getState() == 'I') {
                n++;
            }
        }
        return n;
    }

    public int agentsRecovered() {
        int n = 0;
        for (int i = 0; i < agents.length; i++) {
            if (agents[i].getState() == 'R') {
                n++;
            }
        }
        return n;
    }

    public int totalAgents() {
        return agents.length;
    }

    public Agent getAgent(int i) {
        return agents[i];
    }

}
