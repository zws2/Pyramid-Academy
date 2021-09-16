package com.company;

public class Human extends Player {

    public Human(){
        name = "Human";
        position = new int[]{9,0};
        token = 'O';
        attackMod = 2;
        damageDie = 8;
        damageMod = 2;
        ac = 13;
        hp = 15;
    }

    public String toString(){return name + " is at " + hp +" hp";}

}
