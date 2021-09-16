package com.company;

public class Goblin {

    private int[] position = {};
    private final char token = 'X';

    public Goblin(){
        position = new int[]{0,9};
    }


    public String toString(){return "X";}

    public void takeTurn(){
        char[][] grid = Game.getGrid();
        System.out.println("Enemy Turn " + position[0] + position[1]);
        if(position[0] >= 0 && position[1] >= 0){
            if(grid[position[0]+1][position[1]] == ' '){
                System.out.println("up");
                grid[position[0]][position[1]] = ' ';
                grid[position[0]+1][position[1]] = 'X';
            }else if(grid[position[0]-1][position[1]] == ' '){
                System.out.println("down");
                grid[position[0]][position[1]] = ' ';
                grid[position[0]+1][position[1]] = 'X';
            }else if(grid[position[0]][position[1]+1] == ' '){
                System.out.println("right");
                grid[position[0]][position[1]] = ' ';
                grid[position[0]+1][position[1]] = 'X';
            }else if(grid[position[0]][position[1]-1] == ' '){
                System.out.println("left");
                grid[position[0]][position[1]] = ' ';
                grid[position[0]+1][position[1]] = 'X';
            }else System.out.println("no move");
        }
    }
}
