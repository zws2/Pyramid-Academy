package com.company;

public class Character {

    protected char token;
    protected int[] position = {};

    public void takeTurn(){
        char[][] grid = Game.getGrid();
        System.out.println("Enemy Turn " + position[0] + position[1]);
        if(position[0] >= 0 && position[1] >= 0){
            if(attemptMove(1,0)){
                System.out.println("up");
            }else if(attemptMove(-1,0)){
                System.out.println("down");
            }else if(attemptMove(0,1)){
                System.out.println("left");
            }else if(attemptMove(0,-1)){
                System.out.println("right");
            }else System.out.println("no move");
        }
    }

    private boolean attemptMove(int vert, int hor){
        char[][] grid = Game.getGrid();
        if(grid[position[0]+vert][position[1]+hor] == ' '){
            grid[position[0]][position[1]] = ' ';
            grid[position[0]+vert][position[1]+hor] = token;
            return true;
        }else return false;
    }
}
