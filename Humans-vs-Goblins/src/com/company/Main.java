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
        
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            initGrid();

            do {
                enemyTurn();
                displayGrid();
                do {
                    System.out.println("Please enter a direction: ");
                    input = scanner.nextLine();
                } while (!input.matches("[nsewNSEW]"));
                enemyTurn();
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

        grid[0][9] = 'X';
        grid[9][0] = 'O';
    }
    public static void enemyTurn(){
        System.out.println("Enemy Turn");

    }
    public static void displayGrid(){
        System.out.println("____________________");
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print("|"+grid[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("____________________");
    }
}