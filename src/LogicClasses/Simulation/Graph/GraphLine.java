/*
 * A graphline is a line in the graph. 
 * It has a color and an arraylist of integers, which can manipulated and accessed in many ways. 
 */

package LogicClasses.Simulation.Graph;

import java.util.ArrayList;
import LogicClasses.UtilitiesClasses.Color;

public class GraphLine {

    private ArrayList<Integer> data = new ArrayList<Integer>();

    private Color color;

    public GraphLine(Color color) {
        this.color = color;

    }

    public int getDataAtIndex(int index) {
        return data.get(index);
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public void setData(ArrayList<Integer> data) {
        this.data = data;
    }

    public void addData(int data) {
        this.data.add(data);
    }

    public int getLength() {
        return data.size();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
