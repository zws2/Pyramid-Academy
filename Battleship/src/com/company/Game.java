package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static char[][] grid;
    private static boolean gameOver = false;
    public static final int GRID_SIZE = 10;
    public static final int STARTING_FLEET_SIZE = 5;

    private static Scanner scanner;

    public static void playGame(){
        scanner = new Scanner(System.in);
        String input = "";

        do {
            initGrid();

            Player p1 = new Player();
            Player p2 = new Player();

            p1.setName(askName("one"));
            p1.setName(askName("two"));

            p1.getFleet().add(new Ship(3, new int[]{0,0}, 'v'));
            p2.getFleet().add(new Ship(3, new int[]{0,0}, 'v'));

            do {
                takeTurn(p1);
                if(gameOver)break;

                takeTurn(p2);
                if(gameOver)break;
            } while (!gameOver);

            input = askToPlayAgain();
        }while(input.equals("yes") || input.equals("y"));
        scanner.close();
    }

    private static void takeTurn(Player p){
        String input = "";
        System.out.println(p.getName() + "'s Turn...");
        do {
            System.out.println("Please enter coordinates: ");
            input = scanner.nextLine();
        } while (!input.matches("[1-9][1-9]"));

        p.attack(input);
        displayHiddenGrid(p.getShots(), p.getFleet());
    }

    private static String askName(String s){
        String input = "";
        do {
            System.out.println("Player " + s + " enter name: ");
            input = scanner.nextLine();
        } while (!input.matches("[a-zA-Z]{1,10}"));

        return input;
    }

    private static String askToPlayAgain(){
        System.out.println("Game over");
        System.out.println("Do you want to play again? (yes or no)");

        String input = "";
        do{
            input = scanner.nextLine();
            input = input.toLowerCase();
        }while(!input.equals("yes") && !input.equals("no")
                &&!input.equals("y") && !input.equals("n"));
        return input;
    }

    private static void initGrid(){
        grid = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = ' ';
            }
        }

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

    private static void displayHiddenGrid(ArrayList<int[]> shots, ArrayList<Ship> enemyFleet){


        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: enemyFleet){
            System.out.println("ship");
            shipPositions.addAll(s.getCoords());
        }

        System.out.println("Displaying coords for ships");
        for(int[] arr: shipPositions){
            System.out.println(arr[0] + " " + arr[1]);
        }

//        System.out.println("____________________");
//        for (int i = 0; i < GRID_SIZE; i++) {
//            for (int j = 0; j < GRID_SIZE; j++) {
//                if(shots.contains(new int[]{i,j})){
//                }
//                System.out.print("|"+ ' ');
//            }
//            System.out.println("|");
//        }
//        System.out.println("____________________");
    }

    private static void displayGrid(Ship[] fleet){
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

