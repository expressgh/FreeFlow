package com.company;
import java.awt.*;
import java.util.ArrayList;

public class Circle extends Cell {

    private Color color;
    private ArrayList<Pipe> connectedPipes;


    public Circle(Color color, int x, int y) {
        super(x, y);
        connectedPipes = new ArrayList<Pipe>();
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void addPipe(Pipe pipe){
        connectedPipes.add(pipe);
    }

    public ArrayList<Pipe> getConnectedPipes() {
        return connectedPipes;
    }

    public void setConnectedPipes(ArrayList<Pipe> connectedPipes) {
        this.connectedPipes = connectedPipes;
    }
}
