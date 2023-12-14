package LogicClasses.Simulation.AgentFactory;

import LogicClasses.Simulation.Agent;
import LogicClasses.UtilitiesClasses.AABB;

public interface AgentFactory {

    public Agent createAgent(AABB simWindow);

}
