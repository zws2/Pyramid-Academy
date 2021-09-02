package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static String guessed_letters = "";//string that tracks previously guessed letters
    static String wrong_letters = ""; //letters guessed that were not in codeword
    static String codeword = "cat";//codeword for the user to guess

    static int num_letters_revealed = 0;//how many letters in the codeword have been guessed

    static final int MAX_WRONG_GUESSES = 6;//amount of times player can guess incorrectly

    public static void main(String[] args) {
        playHangman();
    }

    //this function initiates the game of hangman taking scanner input
    //and looping until an end condition is met.
    private static void playHangman(){

        Scanner scanner = new Scanner(System.in);
        String input;
        String revealed_codeword;

        String playAgain = "yes";
        while(playAgain.equals("yes") || playAgain.equals("y")){

            codeword = generateRandomWord();
            revealed_codeword = codeword.replaceAll("[a-z]", "_");
            while(wrong_letters.length() < MAX_WRONG_GUESSES){
                drawHangman();
                System.out.println(revealed_codeword);
                System.out.println("Please guess a letter:");

                boolean loop = true;
                while(loop){
                    input = scanner.nextLine();
                    input = input.toLowerCase();

                    //make sure it is a single letter and that the player hasnt already guessed the letter
                    if(input.matches("[a-z]{1}") && !guessed_letters.contains(input)){
                        guessed_letters = guessed_letters + input;
                        loop = false;
                    } else{
                        System.out.println("Input a single character you have not guessed before.");
                    }
                }

                revealed_codeword = calculateRevealedCodeword();
                if(num_letters_revealed == codeword.length()){//You win
                    System.out.println(codeword);
                    System.out.printf("Yes! The secret word is \"%s\"! You have won!\n", codeword);
                    break;
                }
            }
            if(wrong_letters.length() >= MAX_WRONG_GUESSES){//You lose
                drawHangman();
                System.out.println("You lose!");
            }

            boolean has_looped = false;
            do{
                if(has_looped) System.out.println("please enter yes or no");
                System.out.println("Do you want to play again? (yes or no)");

                input = scanner.nextLine();
                input = input.toLowerCase();
            }while(!(input.equals("yes") || input.equals("no") || input.equals("y") || input.equals("n")));

            playAgain = input;

            //reset instance variables
            guessed_letters = "";
            wrong_letters = "";
            num_letters_revealed = 0;
        }
    }

    //this function draws the hangman stick figure
    private static void drawHangman(){

        System.out.printf("missed Letters: %s\n", wrong_letters);

        switch(wrong_letters.length()){
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
    private static String calculateRevealedCodeword(){
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

            if(guessed_letters.length()>0){
                //if no new letters were revealed, the guess was wrong.
                if(temp_num_letters_revealed == num_letters_revealed)
                    wrong_letters = wrong_letters + guessed_letters.substring(guessed_letters.length()-1, guessed_letters.length());
                else num_letters_revealed = temp_num_letters_revealed;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static String generateRandomWord(){
        Random rand = new Random();

        ArrayList<String> words = new ArrayList<String>();
        words.add("cat");
        words.add("dog");
        words.add("umbrella");
        words.add("waterfall");
        words.add("house");
        words.add("computer");
        words.add("java");
        words.add("flower");
        words.add("candle");
        words.add("music");

        return words.get(rand.nextInt(words.size()));
    }
}
