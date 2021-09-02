package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_GUESSES = 6;

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Hello! What is your name?");

        String name = scanner.nextLine();

        System.out.println("Well, Abaddon, I am thinking of a number between 1 and 20.");

        int guess = 0, number = 0, counter = 0;
        number = rand.nextInt(20) + 1;

        System.out.println(number);

        while(guess != number && counter < MAX_GUESSES){
            System.out.println("Take a Guess.");
            try{
                guess = scanner.nextInt();
                counter++;
            }catch(Exception e){
                System.out.println("That was not a number.");
            }
        }

        if(counter <= MAX_GUESSES) System.out.println("Good job, Abaddon! You guessed my number in 3 guesses!");
        else System.out.println("You ran out of guesses");

    }
}
