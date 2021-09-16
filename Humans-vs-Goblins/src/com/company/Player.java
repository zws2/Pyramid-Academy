package com.company;

public class Player {

    protected char token;
    protected int[] position = {};

    public void takeTurn(){
        char[][] grid = Game.getGrid();
        if(position[0] >= 0 && position[1] >= 0){
            if(attemptMove(new int[]{1,0})){
                System.out.println("up");
            }else if(attemptMove(new int[]{-1,0})){
                System.out.println("down");
            }else if(attemptMove(new int[]{0,1})){
                System.out.println("left");
            }else if(attemptMove(new int[]{0,-1})){
                System.out.println("right");
            }else System.out.println("no move");
        }
    }

    protected boolean attemptMove(int[] coords){
        if(position[0]-coords[0] >= Game.GRID_SIZE || position[1]+coords[1] >= Game.GRID_SIZE
            || position[0]-coords[0] < 0 || position[1]+coords[1] < 0) return false;

        char[][] grid = Game.getGrid();
        if(grid[position[0]-coords[0]][position[1]+coords[1]] == ' '){

            grid[position[0]][position[1]] = ' ';
            grid[position[0]-coords[0]][position[1]+coords[1]] = token;

            position[0] = position[0]-coords[0];
            position[1] = position[1]+coords[1];

            return true;
        }else return false;
    }

}
