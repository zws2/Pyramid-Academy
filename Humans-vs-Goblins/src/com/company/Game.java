package com.company;

import java.util.Scanner;

public class Game {

    private static char[][] grid;
    private static boolean gameOver = false;
    public static final int GRID_SIZE = 10;

    public static void initGame(){
        initGrid();

        Scanner scanner = new Scanner(System.in);
        String input;

        Goblin g = new Goblin();
        Human h = new Human();
        Player[] p = new Player[]{g,h};

        do {
            initGrid();

            do {
                g.takeTurn();
                displayGrid();
                do {
                    System.out.println("Please enter a direction: ");
                    input = scanner.nextLine();
                } while (!input.matches("[nsewNSEW]"));
                h.takeTurn();
                displayGrid();
            } while (!gameOver);

            displayGrid();
            System.out.println("Game over");
            System.out.println("Do you want to play again? (yes or no)");

            do{
                input = scanner.nextLine();
                input = input.toLowerCase();
            }while(!input.equals("yes") && !input.equals("no")
                    &&!input.equals("y") && !input.equals("n"));

        }while(input.equals("yes") || input.equals("y"));
        scanner.close();
    }

    private static void takeTurn(){}

    private static void initGrid(){
        grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = ' ';
            }
        }

        grid[0][9] = 'X';
        grid[9][0] = 'O';
    }

    private static void displayGrid(){
        System.out.println("____________________");
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print("|"+grid[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("____________________");
    }

    public static char[][] getGrid() {
        return grid;
    }

    public static void setGrid(char[][] grid) {
        Game.grid = grid;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Game.gameOver = gameOver;
    }


}
