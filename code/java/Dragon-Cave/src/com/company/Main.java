package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n");

        Scanner scanner = new Scanner(System.in);
        try{
            String input = scanner.nextLine();
        }catch(Exception ignored){}

        if(input.equals("1")){
            System.out.print("You enter the cave...\n" +
                    "You hear from within a deep thumping...\n" +
                    "Like the beating heart of some massive creature...\n" +
                    "No... its... music? Is that a saxophone solo?\n" +
                    "Multicolored lights come streaming through the darkness...\n" +
                    "A disco ball! And... A dancing dragon with an afro and glistening golden pants!\n" +
                    "The dragon moonwalks towards you and extends his hand in a bow...\n" +
                    "You boogie the night away without a care in the world...\n" +
                    "You awake in your bed as light streams in through your window...\n" +
                    "You realise with a smile, it was a dream you will treasure forever.\n");
        }else if(input.equals("2")){
            System.out.print("As you enter the cave, you hold your torch high to ward away the shadows...\n" +
                    "Until a sudden gust snuffs out your light, engulfing you in darkness...\n" +
                    "You hear from deeper within A slow, rythmic thumping...\n" +
                    "Like the beating heart of some massive creature.\n" +
                    "You realize the air within the cave is changing directions...\n" +
                    "As though in tune with massive lungs...\n" +
                    "Your foot slips on something damp and you let out a screech as you stumble!\n" +
                    "The breathing stops...\n" +
                    "You feel a weight on your chest as something slimy drips onto your face...\n" +
                    "Suddenly you awake in your bed, startled to find your cat sleeping on your chest!\n" +
                    "Just a nightmare... but surely they weren't trying to eat you... right?\n");
        }
    }
}
