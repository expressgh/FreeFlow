package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Game {

    private Date huidigeSpeeltijd;

    private ArrayList<Level> levels;
    private Level currentLevel;

    private ArrayList<Circle> finishedCircles;
    public HashMap<Color,String> colorStringHashMap = new HashMap<Color,String>();


    public Game(){
        levels = new ArrayList<Level>();
        finishedCircles = new ArrayList<>();
        colorStringHashMap.put(Color.BLACK, "Black");
        colorStringHashMap.put(Color.RED, "Red");
    }

    public boolean placePipe(Circle circle, int x, int y){
        Pipe pipe = new Pipe(x, y, circle.getColor());
        return currentLevel.changeCellToPipe(pipe);

    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void addLevel(Level level){
        levels.add(level);
    }


    public void displayGrid(){
        for (int y = 0; y < currentLevel.getGrid().size(); y++) {
            for (int x = 0; x < currentLevel.getGrid().get(y).size(); x++) {
                Cell cell = currentLevel.getGrid().get(y).get(x);
                if (cell instanceof Circle){
                    System.out.print("X");
                }
                else if (cell instanceof Pipe){
                    System.out.print("Y");
                }
                else{
                    System.out.print("O");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public ArrayList<Circle> getFinishedCircles() {
        return finishedCircles;
    }

    public void setFinishedCircles(ArrayList<Circle> finishedCircles) {
        this.finishedCircles = finishedCircles;
    }

}
