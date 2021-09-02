package com.company;

import java.util.Scanner;

public class Main {

    static String guessed_letters = "";
    static String codeword = "cat";

    static int num_wrong_guesses = 0;
    static int num_letters_revealed = 0;

    public static void main(String[] args) {
        playHangman();
    }

    private static void playHangman(){

        Scanner scanner = new Scanner(System.in);
        String input;

        while(num_wrong_guesses<6){
            drawHangman();
            System.out.println("Please guess a letter:");

            boolean loop = true;
            while(loop){
                input = scanner.nextLine();

                if(input.matches("[A-Za-z]{1}")){

                    input = input.toLowerCase();
                    guessed_letters = guessed_letters + input;
                    loop = false;
                } else{
                    System.out.println("Input a single character only.");
                }
            }

            System.out.println(revealedCodeword());
        }
        if(num_letters_revealed == codeword.length()){
            System.out.println("Hooray!");
        }else System.out.println("You lose!");
    }

    private static void drawHangman(){

        System.out.printf("missed Letters: %s\n", guessed_letters);

        switch(num_wrong_guesses){
            case 0: System.out.print(
                    " +--+\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "____|\n");
                break;
            case 1: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    "    |\n" +
                    "    |\n" +
                    "____|\n");
                break;
            case 2: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    " |  |\n" +
                    "    |\n" +
                    "____|\n");
                break;
            case 3: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    " |  |\n" +
                    " |  |\n" +
                    "____|\n");
                break;
            case 4: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    " |\\ |\n" +
                    " |  |\n" +
                    "____|\n");
                break;
            case 5: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    "/|\\ |\n" +
                    " |  |\n" +
                    "____|\n");
                break;
            case 6: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    "/|\\ |\n" +
                    "/|  |\n" +
                    "____|\n");
                break;
            default: break;
        }
    }

    private static String revealedCodeword(){
        String str = "";

        int temp_num_letters_revealed = 0;

        try{
            for (int i = 0; i < codeword.length(); i++) {
                String current_letter = codeword.substring(i,i+1);

                if(guessed_letters.contains(current_letter)){
                    temp_num_letters_revealed++;
                    str = str + current_letter;
                } else str = str + "_";
            }

            if(temp_num_letters_revealed == num_letters_revealed) num_wrong_guesses++;
            else num_letters_revealed = temp_num_letters_revealed;

        }catch(Exception e){
            System.out.println("Could not draw codeword.");
        }
        return str;
    }
}
