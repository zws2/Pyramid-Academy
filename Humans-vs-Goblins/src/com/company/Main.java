package com.company;

public class Main {

    public static char[][] grid;
    public static final int GRID_SIZE = 10;

    public static void main(String[] args) {
	// write your code here

        initGrid();
        displayGrid();


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