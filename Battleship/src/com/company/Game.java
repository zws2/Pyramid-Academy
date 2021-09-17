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

        do {
            initGrid();

            do {



                System.out.println(g.getName() + " Turn...");
                g.takeTurn();
                if(gameOver)break;
                displayGrid();

                System.out.println(h.getName() + " Turn...");
                do {
                    System.out.println("Please enter a direction: ");
                    input = scanner.nextLine();
                } while (!input.matches("[nsewNSEW]"));

                h.attemptMove(getCoords(input));
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

    private static int[] getCoords(String s){
        if(s.charAt(0) == 'n') return new int[]{1,0};
        else if(s.charAt(0) == 's') return new int[]{-1,0};
        else if(s.charAt(0) == 'e') return new int[]{0,1};
        else if(s.charAt(0) == 'w') return new int[]{0,-1};
        else return new int[] {0,0};
    }
}

