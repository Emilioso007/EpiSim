/*
 * The dummy screen that every screen extends.
 */

package ScreenClasses.Screens;

import processing.core.PApplet;

import ScreenClasses.ScreenManager;

public class Screen {

    protected ScreenManager sm;
    protected PApplet p;

    public Screen(ScreenManager sm) {
        this.sm = sm;
        this.p = this.sm.getP();
    }

    public void update() {

    }

    public void render() {

    }

}
