/*
 * A agent factory.
 * Returns a new agent with random position and set radius.
 */

package LogicClasses.Simulation;

import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.Random;

public class AgentMaker {

    private static AgentMaker instance;

    private AgentMaker() {
    }

    public static AgentMaker getInstance() {
        if (instance == null) {
            instance = new AgentMaker();
        }
        return instance;
    }

    public Agent makeAgent(AABB simWindow) {

        return new Agent(simWindow,
                Random.Int(simWindow.getW()),
                Random.Int(simWindow.getH()),
                SimConfig.getAgentRadius());

    }

}
