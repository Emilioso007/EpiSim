package LogicClasses.Simulation.Graph;

import java.sql.Array;
import java.util.ArrayList;

import LogicClasses.ShapesClasses.AABB;

public class GraphManager {

    private AABB graphWindow;

    ArrayList<GraphLine> lines = new ArrayList<GraphLine>();

    public GraphManager(AABB graphWindow) {

        this.graphWindow = graphWindow;

    }

    public void run() {

    }

}
