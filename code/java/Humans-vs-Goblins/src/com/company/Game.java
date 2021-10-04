package com.company;

import java.util.Scanner;

public class Game {

    private static char[][] grid;
    private static boolean gameOver = false;
    public static final int GRID_SIZE = 10;

    public static void initGame(){
        initGrid();

        Scanner scanner = new Scanner(System.in);
        String input = "";

        Goblin g = new Goblin();
        Human h = new Human();

        h.setEnemy(g);
        g.setEnemy(h);

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
                    try{
                        input = scanner.nextLine();
                    }catch(Exception ignored){}
                } while (!input.matches("[nsewNSEW]"));

                h.attemptMove(getCoords(input));
                if(gameOver)break;
                displayGrid();
            } while (!gameOver);

            System.out.println("Game over");
            System.out.println("Do you want to play again? (yes or no)");

            do{
                try{
                    input = scanner.nextLine();
                }catch(Exception ignored){}
                input = input.toLowerCase();
            }while(!input.equals("yes") && !input.equals("no")
                    &&!input.equals("y") && !input.equals("n"));

        }while(input.equals("yes") || input.equals("y"));
        scanner.close();
    }

    public static void combat(Player p1, Player p2){

        do {
            p1.attack(p2);
            if(p1.isDead) break;
            p2.attack(p1);
            if(p2.isDead) break;
        } while (true);

        if(p1.isDead) System.out.println(p2.name + " has won!");
        else System.out.println(p1.name + " has won!");

        gameOver = true;

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

    private static int[] getCoords(String s){
        if(s.charAt(0) == 'n') return new int[]{1,0};
        else if(s.charAt(0) == 's') return new int[]{-1,0};
        else if(s.charAt(0) == 'e') return new int[]{0,1};
        else if(s.charAt(0) == 'w') return new int[]{0,-1};
        else return new int[] {0,0};
    }


}
