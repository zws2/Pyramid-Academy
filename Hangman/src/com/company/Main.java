package com.company;

public class Main {

    static int num_wrong_guesses = 0;
    static String guessed_letters;
    static String codeword;

    public static void main(String[] args) {


        drawHangman();

    }

    private static void drawHangman(){

        switch(num_wrong_guesses){
            case 0: System.out.print(
                    " +--+\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "____|");
                break;
            case 1: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    "    |\n" +
                    "    |\n" +
                    "____|");
                break;
            case 2: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    " |  |\n" +
                    "    |\n" +
                    "____|");
                break;
            case 3: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    " |  |\n" +
                    " |  |\n" +
                    "____|");
                break;
            case 4: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    " |\\ |\n" +
                    " |  |\n" +
                    "____|");
                break;
            case 5: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    "/|\\ |\n" +
                    " |  |\n" +
                    "____|");
                break;
            case 6: System.out.print(
                    " +--+\n" +
                    " O  |\n" +
                    "/|\\ |\n" +
                    "/|  |\n" +
                    "____|");
                break;
            default: break;

        }
    }
}
