import processing.core.*;
import LogicClasses.*;
import ScreenClasses.*;

public class App extends PApplet {

    ScreenManager screenManager;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(600, 400, P2D);

        screenManager = new ScreenManager(this);
    }

    public void draw() {
        background(42);

        screenManager.run();
    }

}
