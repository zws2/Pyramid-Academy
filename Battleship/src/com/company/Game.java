package com.company;

import java.util.Scanner;

public class Game {

    private static char[][] grid;
    private static boolean gameOver = false;
    public static final int GRID_SIZE = 10;
    public static final int STARTING_FLEET_SIZE = 5;

    public static void initGame(){
        initGrid();

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            initGrid();

            Player p1 = new Player();
            Player p2 = new Player();

            do {
                System.out.println("Player one enter name: ");
                input = scanner.nextLine();
            } while (!input.matches("[a-zA-Z]{1,10}"));

            do {

                System.out.println(p1.getName() + "'s Turn...");
                do {
                    System.out.println("Please enter coordinates: ");
                    input = scanner.nextLine();
                } while (!input.matches("[1-9][1-9]"));

                p1.attack(input);
                if(gameOver)break;
                displayGrid();

                System.out.println(p2.getName() + "'s Turn...");
                do {
                    System.out.println("Please enter coordinates: ");
                    input = scanner.nextLine();
                } while (!input.matches("[1-9][1-9]"));

                p2.attack(input);
                if(gameOver)break;
                displayGrid();

            } while (!gameOver);

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

    public static void combat(){

        gameOver = true;

    }

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
}

