package com.company;

import java.util.Scanner;

public class Main {

    private static char[] board;
    private static char player_token = ' ';

    final static int BOARD_SIZE = 9;

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
        input = input.toUpperCase();
        player_token = input.charAt(0);

        do{
            drawBoard();
            do{
                input = scanner.nextLine();
            }while(!input.matches("[1-9]"));
            board[Integer.parseInt(input)-1] = player_token;

        }while(!isBoardFull() && !hasWon('X') && !hasWon('O'));
        drawBoard();
        System.out.println("Game over");
    }

    private static boolean hasWon(char mark){

        final int BOARD_LEN = 3;

        //check row
        int start = 0;
        for (int i = start; i < BOARD_SIZE; i++) {
            if(board[i] != mark){
                start += BOARD_LEN;
                i = start;
            }else if(i == start + BOARD_LEN-1){
                System.out.println("row win for " + mark);
                return true;
            }
        }

        //check col
        start = 0;
        for (int i = start; i < BOARD_SIZE; i+=BOARD_LEN) {
            if(board[i] != mark){
                start++;
                i = start;
            }else if(i == BOARD_SIZE-BOARD_LEN+start){
                System.out.println("row win for " + mark);
                return true;
            }
        }

        return false;
    }

    private static void initBoard(){
        board = new char[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = ' ';
        }
    }

    private static boolean isBoardFull(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            if(board[i] == ' ') return false;
        }
        return true;
    }

    private static void drawBoard(){

        System.out.printf("%c|%c|%c\n", board[0], board[1], board[2]);
        System.out.println("------");
        System.out.printf("%c|%c|%c\n", board[3], board[4], board[5]);
        System.out.println("------");
        System.out.printf("%c|%c|%c\n", board[6], board[7], board[8]);

    }
}
