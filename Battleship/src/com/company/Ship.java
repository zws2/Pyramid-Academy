package com.company;

public class Ship {

    int size;
    int[] position;
    char layout;

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
