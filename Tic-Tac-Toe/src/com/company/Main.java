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
        String input;

        do {
            initBoard();

            System.out.print("Welcome to Tic-Tac-Toe!\n" +
                    "Do you want to be X or O?\n");

            do {
                input = scanner.nextLine();
            } while (!input.matches("[xoXO]"));
            input = input.toUpperCase();
            player_token = input.charAt(0);

            do {
                moveForComputer();
                drawBoard();
                if (isBoardFull() || hasWon('X') || hasWon('O')) break;

                do {
                    do {
                        input = scanner.nextLine();
                    } while (!input.matches("[1-9]"));
                } while (board[Integer.parseInt(input) - 1] != ' ');
                board[Integer.parseInt(input) - 1] = player_token;
            } while (!isBoardFull() && !hasWon('X') && !hasWon('O'));

            drawBoard();
            System.out.println("Game over");
            System.out.println("Do you want to play again? (yes or no)");

            do{
                input = scanner.nextLine();
                input = input.toLowerCase();
            }while(!input.equals("yes") && !input.equals("no")
                    &&!input.equals("y") && !input.equals("n"));

        }while(input.equals("yes") || input.equals("y"));
    }

    private static void moveForComputer(){

        char computer_token;
        if(player_token == 'X') computer_token = 'O';
        else computer_token = 'X';

        for (int i = 0; i < board.length; i++) {
            if(board[i] == ' '){
                board[i] = computer_token;
                return;
            }
        }
    }

    private static boolean hasWon(char mark){
        if(
        checkBoard(new int[]{0,1,2}, mark) ||
        checkBoard(new int[]{3,4,5}, mark) ||
        checkBoard(new int[]{6,7,8}, mark) ||

        checkBoard(new int[]{0,3,6}, mark) ||
        checkBoard(new int[]{1,4,7}, mark) ||
        checkBoard(new int[]{2,5,8}, mark) ||

        checkBoard(new int[]{0,4,8}, mark) ||
        checkBoard(new int[]{2,4,6}, mark))
        {
            System.out.println(mark + " has won!");
            return true;
        } else return false;
    }

    private static boolean checkBoard(int[] positions, char mark){

        for (int pos : positions) {
            if(board[pos] != mark) return false;
        }
        return true;
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
