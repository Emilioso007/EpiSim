package LogicClasses.Simulation.Graph;

import java.util.ArrayList;

public class GraphLine {

    private ArrayList<Integer> data = new ArrayList<Integer>();

    public GraphLine() {

    }

    public int getDataAtIndex(int index) {
        return data.get(index);
    }

    public void addData(int data) {
        this.data.add(data);
    }

}
