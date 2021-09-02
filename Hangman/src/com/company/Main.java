package com.company;

public class Main {

    static int num_wrong_guesses = 0;
    static String guessed_letters = "a";
    static String codeword = "cat";

    public static void main(String[] args) {


        drawHangman();

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

        try{
            for (int i = 0; i < codeword.length(); i++) {
                String current_letter = codeword.substring(i,i+1);

                if(guessed_letters.contains(current_letter)){
                    System.out.print(current_letter);
                } else System.out.print("_");
            }
        }catch(Exception e){
            System.out.println("Could not draw codeword.");
        }

    }
}
