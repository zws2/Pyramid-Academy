package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Hello! What is your name?");

        String name = scanner.nextLine();

        System.out.println("Well, Abaddon, I am thinking of a number between 1 and 20.");

        int guess, number;
        number = rand.nextInt(20) + 1;

        System.out.println(number);
    }
}
