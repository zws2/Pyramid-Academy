package com.company;

import java.util.ArrayList;

public class Player {
    String name;
    Ship[] fleet;
    ArrayList<int[]> shots;

    public Player() {
        name = "";
        fleet = new Ship[Game.STARTING_FLEET_SIZE];
        shots = new ArrayList<int[]>();
    }

    public Player(String name, Ship[] fleet, ArrayList<int[]> shots) {
        this.name = name;
        this.fleet = fleet;
        this.shots = shots;
    }

    public void attack(String coords){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship[] getFleet() {
        return fleet;
    }

    public void setFleet(Ship[] fleet) {
        this.fleet = fleet;
    }
}
