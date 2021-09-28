package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static String guessed_letters = "";
    static String wrong_letters = "";
    static String codeword = "";
    static String codeword_progress;

    static int num_letters_revealed = 0;

    static final int MAX_WRONG_GUESSES = 6;

    static Scanner scanner;

    public static void main(String[] args) {
        playHangman();
    }

    private static void playHangman(){
        scanner = new Scanner(System.in);

        while(true){

            codeword = generateRandomWord();
            codeword_progress = codeword.replaceAll("[a-z]", "_");
            while(wrong_letters.length() < MAX_WRONG_GUESSES){
                drawHangman();
                System.out.println(codeword_progress);
                askForGuess();

                calculateCodewordProgressFunc();
                if(num_letters_revealed == codeword.length()){
                    System.out.printf("Yes! The secret word is \"%s\"! You have won!\n", codeword);
                    break;
                }
            }
            if(wrong_letters.length() >= MAX_WRONG_GUESSES){
                drawHangman();
                System.out.printf("You lose!\n The secret word is \"%s\"!\n", codeword);
            }

            if(!askToPlayAgain()) break;

            guessed_letters = "";
            wrong_letters = "";
            num_letters_revealed = 0;
        }
        scanner.close();
    }

    private static void askForGuess(){askForGuess("");}

    private static void askForGuess(String input){
        System.out.println("Please guess a letter:");

        try{
            input = scanner.nextLine();
        }catch(Exception ignored){}
        input = input.toLowerCase();

        if(!input.matches("[a-z]{1}") || guessed_letters.contains(input)){
            askForGuess(input);
        }else guessed_letters = guessed_letters + input;

    }

    private static boolean askToPlayAgain(){return askToPlayAgain("");}

    private static boolean askToPlayAgain(String input){
        System.out.println("Do you want to play again? (yes or no)");

        try{
            input = scanner.nextLine();
        }catch(Exception ignored){}
        input = input.toLowerCase();

        if(!(input.equals("yes") || input.equals("no") || input.equals("y") || input.equals("n"))){
            return askToPlayAgain(input);
        }else{
            if(input.equals("yes") || input.equals("y")) return true;
            else return false;
        }
    }

    private static void calculateCodewordProgressFunc(){

        String starting_progress = codeword_progress;
        codeword_progress = codeword.chars().mapToObj(c -> (char)c + "").reduce("", (s, c) -> {
            if(guessed_letters.contains(c)){
                s = s + c;
            } else s = s + "_";
            return s;
        });

        if(starting_progress.equals(codeword_progress))
            wrong_letters = wrong_letters + guessed_letters.substring(guessed_letters.length()-1);

        num_letters_revealed = (int)codeword_progress.chars().filter(c -> c != '_').count();
    }

    private static String generateRandomWord(){
        Random rand = new Random();
        ArrayList<String> words = new ArrayList<String>();

        Scanner s = null;
        try{
            File f = new File("src\\com\\company\\words.txt");
            s = new Scanner(f);

            while(s.hasNextLine()){
                words.add(s.nextLine());
            }

        }catch(IOException e){e.printStackTrace();
        } finally{
            if(s!=null) s.close();
        }

        return words.get(rand.nextInt(words.size()));
    }

    private static void drawHangman1(){

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

    private static void drawHangman(){

        System.out.printf("missed Letters: %s\n", wrong_letters);
        ArrayList<String> hangman = new ArrayList<String>();
        Scanner s = null;
        try{
            File f = new File("src\\com\\company\\draw.txt");
            s = new Scanner(f);

            int i=0;
            while(s.hasNextLine()){
                String str = s.nextLine();
                hangman.add(str);
                if(str.equals("=========")){
                    if(i == wrong_letters.length()){
                        break;
                    }else{
                        hangman.clear();
                        i++;
                    }
                }
            }

        }catch(IOException e){e.printStackTrace();
        } finally{
            if(s!=null) s.close();
        }
        hangman.forEach(System.out::println);
    }
}
