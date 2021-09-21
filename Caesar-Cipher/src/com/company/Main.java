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
        String mode = "";
        String message = "";
        int shift = 0;


        do {

            mode = askForMode();
            if(!mode.equals("!exit")) break;
            System.out.println(mode);
            message = askForMessage();
            shift = askForShift();

            System.out.println("Your translated text is: \n" + caesarCipher(message, shift));

        }while(true);
        scanner.close();
    }

    private static String askForMode(){
        String input = "";
        System.out.println("Do you wish to encrypt or decrypt a message? (!exit to exit)");
        do {
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
            input = input.toLowerCase();
        } while (!input.matches("(encrypt|decrypt|e|n|d|\\!exit)"));

        return input;
    }

    private static String askForMessage(){
        String input = "";
        System.out.println("Enter your message:");
        try{
            input = scanner.nextLine();
        }catch(Exception ignored){}

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

        StringBuilder output = new StringBuilder();
        //A-Z 65-90
        //a-z 97-122

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
                c += shift;
                if(c > 90 && c < 97) c += 6;
                else if(c > 122){
                    c -= 52;
                    if(c > 90 && c < 97) c += 6;
                }
            }
            output.append(c);
        }

        return output.toString();
    }
}
