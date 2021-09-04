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

        drawBoard();


    }

    private static void initBoard(){
        final int BOARD_SIZE = 9;
        board = new char[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = ' ';
        }
    }

    private static void drawBoard(){

        System.out.printf("%c|%c|%c\n", board[0], board[1], board[2]);
        System.out.println("------");
        System.out.printf("%c|%c|%c\n", board[3], board[4], board[5]);
        System.out.println("------");
        System.out.printf("%c|%c|%c\n", board[6], board[7], board[8]);

    }
}
