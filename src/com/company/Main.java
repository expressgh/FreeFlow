package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Game game = null;

    public static void main(String[] args) {

//test
        Scanner scanner = new Scanner(System.in);
        Circle[] circleArray = new Circle[]{new Circle(Color.RED, 2, 2), new Circle(Color.RED, 4, 4)};

        Level level1 = new Level(circleArray, 5, 5);

        game = new Game();
        game.addLevel(level1);
        game.setCurrentLevel(level1);


        while (game.getFinishedCircles().size() != game.getCurrentLevel().getCircleArray().length){
            game.displayGrid();
            System.out.println("============");
            System.out.println("Enter your x-coordinate of the circle you want to draw your pipe from: ");
            int xCircle = scanner.nextInt();
            System.out.println("Enter your y-coordinate of the circle you want to draw your pipe from: ");
            int yCircle = scanner.nextInt();
            var circle = (Circle)level1.getGrid().get(xCircle).get(yCircle);
            System.out.println("You selected the " + game.colorStringHashMap.get(circle.getColor()) + " circle.");
            playCircle(circle);
        }
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⠻⠿⣿⣿⣿⣿⣿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠟⠉⠄⠄⠄⠄⠄⠄⠄⠉⢟⠉⠄⠄⠄⠄⠄⠈⢻⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⡿⠃⠄⠄⠤⠐⠉⠉⠉⠉⠉⠒⠬⡣⠤⠤⠄⠄⠄⠤⠤⠿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⠁⠄⠄⠄⠄⠄⠄⠠⢀⡒⠤⠭⠅⠚⣓⡆⡆⣔⡙⠓⠚⠛⠄⣹⠿⣿\n" +
                "⣿⠟⠁⡌⠄⠄⠄⢀⠤⠬⠐⣈⠠⡤⠤⠤⣤⠤⢄⡉⢁⣀⣠⣤⣤⣀⣐⡖⢦⣽\n" +
                "⠏⠄⠄⠄⠄⠄⠄⠄⠐⠄⡿⠛⠯⠍⠭⣉⣉⠉⠍⢀⢀⡀⠉⠉⠉⠒⠒⠂⠄⣻\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠩⠵⠒⠒⠲⢒⡢⡉⠁⢐⡀⠬⠍⠁⢉⣉⣴⣿⣿\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⢉⣒⡉⠁⠁⠄⠄⠉⠂⠙⣉⣁⣀⣙⡿⣿⣿\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⢠⠄⡖⢉⠥⢤⠐⢲⠒⢲⠒⢲⠒⠲⡒⠒⡖⢲⠂⠄⢀⣿\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠈⢆⡑⢄⠳⢾⠒⢺⠒⢺⠒⠚⡖⠄⡏⠉⣞⠞⠁⣠⣾⣿\n" +
                "⠄⠄⠄⠄⠄⠄⢆⠄⠄⠄⠈⠢⠉⠢⠍⣘⣒⣚⣒⣚⣒⣒⣉⠡⠤⣔⣾⣿⣿⣿\n" +
                "⠷⣤⠄⣀⠄⠄⠄⠈⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣤⣾⣿⣿⣿⣿⣿\n" +
                "⠄⠄⠉⠐⠢⠭⠄⢀⣒⣒⡒⠄⠄⠄⠄⠄⠄⣀⡠⠶⢶⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠁⠈⠄⠄⠄⠄⠄⠄⠈⠻⣿⣿⣿⣿⣿⣿⣿");


    }


    public static void playCircle(Circle circle){

        Level level1 = game.getCurrentLevel();
        boolean bool = true;

        int circleXpos = circle.getxPos();
        int circleYpos = circle.getyPos();

        Scanner scanner = new Scanner(System.in);

        if (level1.getGrid().get(circleXpos).get(circleYpos) instanceof Circle) {


            while (bool) {
                game.displayGrid();
                System.out.println("Choose UP, DOWN, LEFT or RIGHT to place your pipe:");
                var direction = scanner.next();
                switch(direction)
                {
                    case "UP":
                        --circleYpos;
                        bool = placePipe(circleXpos, circleYpos, circle);
                        break;
                    case "DOWN":
                        ++circleYpos;
                        bool = placePipe(circleXpos, circleYpos, circle);
                        break;
                    case "LEFT":
                        --circleXpos;
                        bool = placePipe(circleXpos, circleYpos, circle);
                        break;
                    case "RIGHT":
                        ++circleXpos;
                        bool = placePipe(circleXpos, circleYpos, circle);
                        break;
                    default:
                        System.out.println("Incorrect direction. Try Again.");
                        break;
                }

            }
        } else {
            System.out.println("There is no circle here.");
        }

    }

    public static boolean placePipe(int xPos, int yPos, Circle circle){
        try{
            if (game.getCurrentLevel().getGrid().get(xPos).get(yPos) instanceof Circle){

                game.getFinishedCircles().add(circle);
                game.getFinishedCircles().add((Circle)game.getCurrentLevel().getGrid().get(xPos).get(yPos));
                System.out.println("You completed the " + game.colorStringHashMap.get(circle.getColor()) + " circle.");
                return false;
            }else{
                game.placePipe(circle, xPos, yPos);
                return true;
            }
        }catch (IndexOutOfBoundsException exception) {
            System.out.println("You hit a wall.");
            game.getCurrentLevel().clearGrid();
            return false;
        }
    }


}
