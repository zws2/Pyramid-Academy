package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static String guessed_letters = "";
    static String wrong_letters = "";
    static String codeword = "";

    static int num_letters_revealed = 0;

    static final int MAX_WRONG_GUESSES = 6;

    static Scanner scanner;
    static String input;

    public static void main(String[] args) {
        playHangman();
    }

    private static void playHangman(){

        scanner = new Scanner(System.in);
        input = "";
        String codeword_progress;

        String playAgain = "yes";
        while(true){

            codeword = generateRandomWord();
            codeword_progress = codeword.replaceAll("[a-z]", "_");
            while(wrong_letters.length() < MAX_WRONG_GUESSES){
                drawHangman();
                System.out.println(codeword_progress);

                askForGuess();

                codeword_progress = calculateCodewordProgress();
                if(num_letters_revealed == codeword.length()){//You win
                    System.out.println(codeword);
                    System.out.printf("Yes! The secret word is \"%s\"! You have won!\n", codeword);
                    break;
                }
            }
            if(wrong_letters.length() >= MAX_WRONG_GUESSES){
                drawHangman();
                System.out.println("You lose!");
            }


            askToPlayAgain();
            if(input.equals("no") || input.equals("n")) break;

            guessed_letters = "";
            wrong_letters = "";
            num_letters_revealed = 0;
        }
    }

    private static void askForGuess(){
        System.out.println("Please guess a letter:");
        do{
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
            input = input.toLowerCase();

        }while(!input.matches("[a-z]{1}") || guessed_letters.contains(input));

        guessed_letters = guessed_letters + input;
    }

    private static void askToPlayAgain(){
        System.out.println("Do you want to play again? (yes or no)");
        do{
            try{
                input = scanner.nextLine();
            }catch(Exception ignored){}
            input = input.toLowerCase();
        }while(!(input.equals("yes") || input.equals("no") || input.equals("y") || input.equals("n")));
    }

    private static String calculateCodewordProgress(){
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

            if(guessed_letters.length()>0){
                if(temp_num_letters_revealed == num_letters_revealed)
                    wrong_letters = wrong_letters + guessed_letters.substring(guessed_letters.length()-1);
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
}
