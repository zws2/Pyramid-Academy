package com.company;

import java.util.Scanner;

public class Main {

    private static char[] board;
    private static char player_token = ' ';

    public static void main(String[] args) {
	// write your code here

        initGame();
    }

    private static void initGame(){

        Scanner scanner = new Scanner(System.in);
        initBoard();

        System.out.print("Welcome to Tic-Tac-Toe!\n" +
                "Do you want to be X or O?\n");

        String input;
        do{
            input = scanner.nextLine();
        }while(!input.matches("[xoXO]"));
        input.toUpperCase();
        player_token = input.charAt(0);

        System.out.println(player_token);



    }

    private static void initBoard(){
        board = new char[9];
        for (char c : board) {
            c = ' ';
        }
    }

    private static void drawBoard(){

    }
}
