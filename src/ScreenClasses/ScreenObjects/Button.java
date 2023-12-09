package ScreenClasses.ScreenObjects;

import LogicClasses.UtilitiesClasses.AABB;
import LogicClasses.UtilitiesClasses.MouseHandler;
import processing.core.PApplet;
import processing.core.PConstants;

public class Button extends AABB {

    private String text, key;

    private boolean pressed = false;
    private boolean pressedA = false, pressedB = true;

    public Button(int x, int y, int w, int h, String text, String key) {
        super(x, y, w, h);
        this.text = text;
        this.key = key;
    }

    public void update() {
        pressedB = !pressedA;
        if (this.contains(MouseHandler.mouseX, MouseHandler.mouseY) && MouseHandler.leftPressed) {
            pressedA = true;
        } else {
            pressedA = false;
        }

        pressed = (pressedA && pressedB);

        if(pressed){
            System.out.println(key);
        }

    }

    public void render(PApplet p) {
        if (pressedA) {
            p.fill(0, 127, 70);
        } else {
            p.fill(0, 147, 81);
        }
        p.rect(getX(), getY(), getW(), getH());

        p.fill(255);
        p.textSize(24);
        p.textAlign(PConstants.CENTER, PConstants.CENTER);
        p.text(text, getX() + getW() / 2, getY() + getH() / 2);

    }

    public String getKey() {
        return key;
    }

    public boolean isPressed() {
        return pressed;
    }

}
