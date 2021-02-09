package com.company;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final ArrayList<List<Cell>> grid;
    private final Circle[] circleArray;

    public Level(Circle[] circleArray, int sizeX, int sizeY){
        this.grid = new ArrayList<>();

        for (int y = 0; y < sizeY; y++) { //2D Array creation & initialization
            this.grid.add(new ArrayList<>());
            for (int x = 0; x < sizeX; x++) {
                this.grid.get(y).add(new Cell(x,y));
            }
        }

        this.circleArray = circleArray;

        for (Circle circle : circleArray) {
            changeCellToCircle(circle);
        }

    }

    private void changeCellToCircle(Circle circle) {
        this.grid.get(circle.getyPos()).set(circle.getxPos(), circle);
    }


    public void clearGrid(){
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(y).size(); x++) {
                Cell tempCell = this.grid.get(y).get(x);
                if (!(tempCell instanceof Circle)){
                    grid.get(y).set(x, new Cell(x, y));
                }

            }
        }

    }

    public boolean changeCellToPipe(Pipe pipe) {
        Cell tempCell = this.grid.get(pipe.getyPos()).get(pipe.getxPos());

        if (tempCell instanceof Pipe) return false;
        else if (tempCell instanceof Circle) return false;
        else{
            this.grid.get(pipe.getyPos()).set(pipe.getxPos(), pipe);
            return true;
        }
    }

    public ArrayList<List<Cell>> getGrid() {
        return grid;
    }

    public Circle[] getCircleArray() {
        return circleArray;
    }


}
