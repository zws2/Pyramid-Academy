package com.company;

public class Player {
    String name;
    Ship[] fleet;

    public Player() {
        name = "";
        fleet = new Ship[Game.STARTING_FLEET_SIZE];
    }

    public void attack(String coords){

    }

    public Player(String name, Ship[] fleet) {
        this.name = name;
        this.fleet = fleet;
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
