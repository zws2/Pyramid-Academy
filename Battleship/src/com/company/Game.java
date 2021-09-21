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

            p1.setEnemy(p2);
            p2.setEnemy(p1);

            p1.setName(askName("one"));
            p1.setName(askName("two"));

            p1.getFleet().add(new Ship(3, new int[]{0,0}, 'v'));
            p1.getFleet().add(new Ship(3, new int[]{0,1}, 'v'));

            p1.addShot(new int[]{0,0});
            p1.addShot(new int[]{7,7});

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

        Player e = p.getEnemy();
        displayShotGrid(p.getShots(), e.getFleet());
        displayFleetGrid(e.getShots(), p.getFleet());
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

        displayGrid();
    }

    private static void displayGrid(){
        System.out.println("____________________");
        for (int y = GRID_SIZE-1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                System.out.print("|"+x+y);
            }
            System.out.println("|");
        }
        System.out.println("____________________");
    }

    private static void displayShotGrid(ArrayList<int[]> shots, ArrayList<Ship> enemyFleet){

        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: enemyFleet){
            shipPositions.addAll(s.getCoords());
        }

        System.out.println("--------------------");
        for (int y = GRID_SIZE-1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if(intListContains(shipPositions, new int[]{x,y})
                    && intListContains(shots, new int[]{x,y})) System.out.print("|X");
                else if(intListContains(shots, new int[]{x,y})) System.out.print("|O");
                else System.out.print("| ");
            }
            System.out.println("|");
        }
        System.out.println("--------------------");
    }

    private static void displayFleetGrid(ArrayList<int[]> enemyShots, ArrayList<Ship> fleet){
        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: fleet){
            shipPositions.addAll(s.getCoords());
        }
        System.out.println("--------------------");
        for (int y = GRID_SIZE-1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if(intListContains(shipPositions, new int[]{x,y})
                        && intListContains(enemyShots, new int[]{x,y})) System.out.print("|*");
                else if(intListContains(shipPositions, new int[]{x,y})) System.out.print("|@");
                else System.out.print("| ");
            }
            System.out.println("|");
        }
        System.out.println("--------------------");
    }

    public static boolean intListContains(ArrayList<int[]> list, int[] pos){
        for(int[] arr: list){
            if(arr[0] == pos[0] && arr[1] == pos[1]) return true;
        }
        return false;
    }

    public static boolean shipListContains(ArrayList<Ship> fleet, int[] pos){
        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: fleet){
            shipPositions.addAll(s.getCoords());
        }

        for(int[] arr: shipPositions){
            if(arr[0] == pos[0] && arr[1] == pos[1]) return true;
        }
        return false;
    }

    public static char[][] getGrid() {
        return grid;
    }

    public static void setGrid(char[][] grid) {
        Game.grid = grid;
    }
}

