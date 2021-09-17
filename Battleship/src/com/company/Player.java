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
