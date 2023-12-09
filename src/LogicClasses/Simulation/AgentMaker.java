package LogicClasses.Simulation;

import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.Random;

public class AgentMaker {

    private AABB simWindow;

    public AgentMaker(AABB simWindow) {

        this.simWindow = simWindow;

    }

    public Agent makeAgent() {

        return new Agent(this.simWindow,
                Random.Int(this.simWindow.getW()),
                Random.Int(this.simWindow.getH()),
                SimConfig.getAgentRadius());

    }

}
