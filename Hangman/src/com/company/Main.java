package com.company;

import java.util.Scanner;

public class Main {

    static String guessed_letters = "";//string that tracks previously guessed letters
    static String codeword = "cat";//codeword for the user to guess

    static int num_letters_revealed = 0;//how many letters in the codeword have been guessed
    static int num_wrong_guesses = 0;//number of times user has input a letter that was not in codeword

    static final int MAX_WRONG_GUESSES = 6;//amount of times player can guess incorrectly

    public static void main(String[] args) {
        playHangman();
    }

    //this function initiates the game of hangman taking scanner input
    //and looping until an end condition is met.
    private static void playHangman(){

        Scanner scanner = new Scanner(System.in);
        String input;

        while(num_wrong_guesses < MAX_WRONG_GUESSES){
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
            if(num_letters_revealed == codeword.length()){//You win
                System.out.println("Hooray! You win!");
                return;
            }
        }
        //You lose
        drawHangman();
        System.out.println("You lose!");
    }

    //this function draws the hangman stick figure
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

    //this function computes the revealed codeword based on previously guessed letters
    //it sets the instance variables num_letters_revealed and num_wrong_guesses depending on the result.
    private static String revealedCodeword(){
        String str = "";//string with the characters that make up the revealed codeword
        int temp_num_letters_revealed = 0;//a temp variable to compare to the previous amount of letters revealed

        try{
            //loops through each letter in the codeword and see if it is contained within the letters guessed
            for (int i = 0; i < codeword.length(); i++) {
                String current_letter = codeword.substring(i,i+1);

                if(guessed_letters.contains(current_letter)){//add that letter to the string
                    temp_num_letters_revealed++;
                    str = str + current_letter;
                } else str = str + "_";//add a _ placeholder
            }

            if(temp_num_letters_revealed == num_letters_revealed) num_wrong_guesses++;//if no new letters were revealed, the guess was wrong.
            else num_letters_revealed = temp_num_letters_revealed;

        }catch(Exception e){
            System.out.println("Could not draw codeword.");
        }
        return str;
    }
}
