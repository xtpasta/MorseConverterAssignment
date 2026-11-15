package common;

import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. English to Morse code");
        System.out.println("2. Morse code to English");
        System.out.print("Choice: ");

        String choice = scanner.nextLine();

        try {
            if (choice.equals("1")){
                System.out.print("English text: ");
                String text = scanner.nextLine();

                String result = converter.englishToMorse(text);

                System.out.println(result);

            } else if (choice.equals("2")){
                System.out.print("Morse: ");
                String morse = scanner.nextLine();

                String result = converter.morseToEnglish(morse);

                System.out.println(result);

            } else {
                System.out.println("Invalid input");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
