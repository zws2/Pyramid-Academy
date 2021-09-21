package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        init();

    }

    private static Scanner scanner;

    public static void init(){
        scanner = new Scanner(System.in);
        String message = "";
        int shift = 0;

        do {
            message = askForMessage();
            shift = askForShift();

            System.out.println("Your translated text is: \n" + caesarCipher(message, shift));

        }while(!message.equals("!exit"));
        scanner.close();
    }

    private static String askForMessage(){
        String input = "";
        do {
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
        } while (!input.matches("[a-zA-Z]+"));

        return input;
    }

    private static int askForShift(){
        String input = "";
        do {
            System.out.println("Enter the key number (1-52)");
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
        } while (!input.matches("5[0-2]|[1-4][0-9]|[1-9]"));

        return Integer.parseInt(input);
    }

    private static String caesarCipher(String message, int shift){

        return message;

    }
}
