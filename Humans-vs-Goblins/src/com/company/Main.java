package com.company;

import java.util.Scanner;

public class Main {

    public static char[][] grid;
    public static final int GRID_SIZE = 10;
    public static final char goblin_token = 'X';
    public static final char human_token = 'X';
    public static boolean gameOver = false;

    public static void main(String[] args) {
	// write your code here

        initGame();


    }

    public static void initGame(){
        initGrid();
        displayGrid();

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            initGrid();

                displayGrid();
                do {
                    do {
                        System.out.println("input");
                        input = scanner.nextLine();
                    } while (!input.matches("[a-z]"));
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
    }
    public static void initGrid(){
        grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    public static void displayGrid(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print("|"+grid[i][j]);
            }
            System.out.println("|");
        }
    }
}