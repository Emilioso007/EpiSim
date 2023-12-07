package ScreenClasses.Screens;

import java.util.ArrayList;

import LogicClasses.Simulation.SimConfig;
import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button;
import processing.core.PApplet;

public class Settings extends Screen{
    
    ArrayList<Button> buttons;

    ScreenManager screenManager;

    PApplet p;

    public Settings(ScreenManager screenManager){
        this.screenManager = screenManager;
        this.p = this.screenManager.getP();
        buttons = new ArrayList<Button>();

        buttons.add(new Button(100, 100, 100, 100, "button1"));
        buttons.add(new Button(200, 100, 100, 100, "button2"));
        buttons.add(new Button(300, 100, 100, 100, "button3"));
        
    }

    public void update(){
        for(Button b : buttons){
            b.update();
        }

        if(buttons.get(0).isPressed()){
            SimConfig.nAgents++;
        }

        if(buttons.get(1).isPressed()){
            SimConfig.nAgents--;
        }

        if(buttons.get(2).isPressed()){
            screenManager.changeScreen(new Simulation(screenManager));
        }

    }

    public void render(){
        for(Button b : buttons){
            b.render(this.screenManager.getP());
        }

        p.fill(255);
        p.textSize(16);
        p.textAlign(PApplet.RIGHT, PApplet.TOP);
        p.text(SimConfig.nAgents, p.width/2, p.height/2);

    }

    

}
