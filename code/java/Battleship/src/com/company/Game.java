package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static char[][] grid;
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
            p2.setName(askName("two"));

            placeFleet(p1);
            placeFleet(p2);

            do {
                giveTurn(p1);
                if(p2.checkIfLost()){
                    displayFleetGrid(p2);
                    break;
                }

                giveTurn(p2);
                if(p1.checkIfLost()){
                    displayFleetGrid(p1);
                    break;
                }
            } while(true);

            input = askToPlayAgain();
        }while(input.equals("yes") || input.equals("y"));
        scanner.close();
    }

    private static void giveTurn(Player p){
        String input = "";
        System.out.println(p.getName() + "'s Turn...");
        displayShotGrid(p);
        do {
            System.out.println("Please enter coordinates: ");
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
        } while (!input.matches("[0-9][0-9]"));
        p.attack(input);
    }

    private static String askName(String s){
        String input = "";
        do {
            System.out.println("Player " + s + " enter name: ");
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
        } while (!input.matches("[a-zA-Z]{1,10}"));

        return input;
    }

    private static String askToPlayAgain(){
        System.out.println("Game over");
        System.out.println("Do you want to play again? (yes or no)");

        String input = "";
        do{
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
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

    private static void placeFleet(Player p){
        String input = "";
        for (int i = 1; i <= STARTING_FLEET_SIZE; i++) {
            System.out.println(p.getName() + ", place ship " + i);
            displayFleetGrid(p);

            int size = 0;
            if(i==1) size = 2;
            else if(i==2 || i==3) size = 3;
            else if(i==4) size = 4;
            else if(i==5) size = 5;
            else return;

            do {
                System.out.println("Please enter coordinates: ");
                try{
                    input = scanner.nextLine();
                }catch(Exception ignored){}
            } while (!input.matches("[0-9][0-9]"));

            int[] shot = new int[]{Character.getNumericValue(input.charAt(0)),
                    Character.getNumericValue(input.charAt(1))};

            do {
                System.out.println("Please enter h or v: ");
                try{
                    input = scanner.nextLine();
                }catch(Exception ignored){}
            } while (!input.matches("[hv]"));

            p.getFleet().add(new Ship(size, shot, input.charAt(0)));

        }
        System.out.println("All ships added for " + p.getName());
        displayFleetGrid(p);
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

    private static void displayShotGrid(Player p){

        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: p.getEnemy().getFleet()){
            shipPositions.addAll(s.getCoords());
        }

        System.out.println("---" + p.getName() + "'s Shots---");
        for (int y = GRID_SIZE-1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if(intListContains(shipPositions, new int[]{x,y})
                    && intListContains(p.getShots(), new int[]{x,y})) System.out.print("|X");
                else if(intListContains(p.getShots(), new int[]{x,y})) System.out.print("|O");
                else System.out.print("| ");
            }
            System.out.println("|");
        }
        System.out.println("--------------------");
    }

    private static void displayFleetGrid(Player p){
        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: p.getFleet()){
            shipPositions.addAll(s.getCoords());
        }
        System.out.println("---" + p.getName() + "'s Fleet---");
        for (int y = GRID_SIZE-1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if(intListContains(shipPositions, new int[]{x,y})
                        && intListContains(p.getEnemy().getShots(), new int[]{x,y})) System.out.print("|*");
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

