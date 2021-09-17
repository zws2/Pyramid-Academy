package com.company;

import java.util.ArrayList;

public class Ship {

    private int size;
    private int[] position;
    private char layout;

    public Ship() {
        size = 0;
        position = new int[] {-1,-1};
        layout = ' ';
    }

    public Ship(int size, int[] position, char layout) {
        this.size = size;
        this.position = position;
        this.layout = layout;
    }

    public ArrayList<int[]> getCoords(){
        ArrayList<int[]> coords = new ArrayList<int[]>();
        int x=0, y=0;
        if(layout == 'h') x = 1;
        else y = 1;

        coords.add(position);

        for (int i = 1; i < size; i++) {
            coords.add(new int[]{position[0] + (i*x), position[1] + (i*y)});
        }

        return coords;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public char getLayout() {
        return layout;
    }

    public void setLayout(char layout) {
        this.layout = layout;
    }
}
