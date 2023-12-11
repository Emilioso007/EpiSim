/*
 * GraphManager keeps track of all the GraphLines.
 */

package LogicClasses.Simulation.Graph;

import java.util.ArrayList;

import LogicClasses.UtilitiesClasses.*;

public class GraphManager {

    private ArrayList<GraphLine> lines = new ArrayList<GraphLine>();

    public GraphManager() {

        lines.add(new GraphLine(new Color(0, 255, 0)));
        lines.add(new GraphLine(new Color(255, 0, 0)));
        lines.add(new GraphLine(new Color(0, 0, 255)));

    }

    public void sendData(int data, int lineIndex) {

        lines.get(lineIndex).addData(data);

    }

    public ArrayList<GraphLine> getLines() {
        return lines;
    }

}
