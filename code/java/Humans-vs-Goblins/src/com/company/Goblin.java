package com.company;

public class Goblin extends Player {


    public Goblin(){
        name = "Goblin";
        position = new int[]{0,9};
        token = 'X';
        attackMod = 1;
        damageDie = 6;
        damageMod = 1;
        ac = 11;
        hp = 7;
        isDead = false;
    }

    public String toString(){return name + " is at " + hp +" hp";}

}
