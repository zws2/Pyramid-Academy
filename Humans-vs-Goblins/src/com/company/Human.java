package com.company;

public class Human {

    private int[] position = {};
    private final char token = 'O';

    public Human(){
        position = new int[]{9,0};
    }

    public String toString(){return "O";}
}
