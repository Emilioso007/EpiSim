import processing.core.*;
import ScreenClasses.*;

public class App extends PApplet {

    ScreenManager screenManager;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(1280, 720, P2D);

        screenManager = new ScreenManager(this);
    }

    public void draw() {
        background(42);
        screenManager.run();
    }

}
