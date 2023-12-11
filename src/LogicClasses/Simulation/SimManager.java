package LogicClasses.Simulation;

import LogicClasses.Simulation.Graph.GraphManager;
import LogicClasses.UtilitiesClasses.AABB;

public class SimManager {

    private int frameCount = 0;

    private Agent[] agents;

    private AABB simWindow;

    public GraphManager graphManager;

    private AgentMaker agentMaker;

    private boolean paused = false;

    public SimManager(AABB simWindow) {

        agents = new Agent[SimConfig.getNAgents()];

        this.simWindow = simWindow;

        this.graphManager = new GraphManager();

        agentMaker = new AgentMaker(this.simWindow);

        for (int i = 0; i < SimConfig.getNAgents(); i++) {
            agents[i] = agentMaker.makeAgent();
        }

        agents[0].setState('I');

    }

    public void run() {

        if (paused) {
            return;
        }
        for (int i = 0; i < agents.length; i++) {
            agents[i].randomWalk();
        }

        if (frameCount % SimConfig.getFramesPerDay() == 0) {
            spreadDisease();
        }

        checkForRecovery();

        if (frameCount % 5 == 0) {
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
                if (frameCount - agents[i].getFrameInfected() > SimConfig.getRecoveryTime()) {
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

    public void togglePause() {
        paused = !paused;
    }

    public boolean isPaused() {
        return paused;
    }

}
