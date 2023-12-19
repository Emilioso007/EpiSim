package LogicClasses.Simulation.AgentFactory;

import LogicClasses.Simulation.Agent;
import LogicClasses.Simulation.SimConfig;
import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.Random;

public class RandomAgentFactory implements AgentFactory{

    public RandomAgentFactory() {
    }

    @Override
    public Agent createAgent(AABB simWindow) {
        return new Agent(simWindow,
                Random.randomInt(simWindow.getW()),
                Random.randomInt(simWindow.getH()),
                SimConfig.getAgentRadius());
    }
    
}
