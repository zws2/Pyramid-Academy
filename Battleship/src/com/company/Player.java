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

    public void addShot(int[] shot){
        shots.add(shot);
    }

    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
}
