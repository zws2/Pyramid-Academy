package com.company;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Ship> fleet;
    private ArrayList<int[]> shots;
    private Player enemy;

    public Player() {
        name = "";
        fleet = new ArrayList<Ship>();
        shots = new ArrayList<int[]>();
    }

    public Player(String name, ArrayList<Ship> fleet, ArrayList<int[]> shots, Player enemy) {
        this.name = name;
        this.fleet = fleet;
        this.shots = shots;
        this.enemy = enemy;
    }

    public void attack(String coords){
        int[] shot = new int[]{Character.getNumericValue(coords.charAt(0)), Character.getNumericValue(coords.charAt(1))};
        shots.add(shot);
        if(Game.shipListContains(enemy.getFleet(), shot)) System.out.println("Hit!");
        else System.out.println("Miss!");
    }

    public boolean checkIfLost(){
        int GRID_SIZE = Game.GRID_SIZE;

        ArrayList<int[]> shipPositions = new ArrayList<int[]>();
        for(Ship s: fleet){
            shipPositions.addAll(s.getCoords());
        }

        for (int y = GRID_SIZE-1; y >= 0; y--) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if(Game.intListContains(shipPositions, new int[]{x,y})
                        && !Game.intListContains(enemy.getShots(), new int[]{x,y})){
                    return false;
                }
            }
        }
        System.out.println(name + " has lost!");
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ship> getFleet() {
        return fleet;
    }

    public void setFleet(ArrayList<Ship> fleet) {
        this.fleet = fleet;
    }

    public ArrayList<int[]> getShots() {
        return shots;
    }

    public void setShots(ArrayList<int[]> shots) {
        this.shots = shots;
    }

    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
}
