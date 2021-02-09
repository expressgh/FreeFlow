package com.company;
import java.awt.*;

public class Pipe extends Cell {

    private final Color color;

    public Pipe(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }
}

