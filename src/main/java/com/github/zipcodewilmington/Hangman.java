package com.github.zipcodewilmington;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
// Joe Huntenburg

public class Hangman {
    private static String correctWord;// will be the word selected from an array
    private static int remainingTries;// this will count down num of tries
    private static ArrayList<String> word = new ArrayList<>();//list of possible words
    private static String used = ""; //place for already selected letters to be stored/displayed

    public static void hangmanWord() {
        String[] words = {
                "APPLE",
                "TABLE",
                "MUSIC",
                "BEACH",
                "HOUSE",
                "HAPPY",
                "PIZZA",
                "WORLD",
                "GLASS",
                "EARTH"
        };

        int rand = new Random().nextInt(words.length);
        correctWord = words[rand];  //chooses a word from the array

        for (int i = 0; i < correctWord.length(); i++) {
            word.add("_"); // goes through each letter of the word and displays it as an underscore
        }

        for (int j = 0; j < correctWord.length(); j++) {
            System.out.print(word.get(j));
        }


    }

    /*   public static void begin() {
           Scanner scan = new Scanner(System.in);
           System.out.printf("Welcome to WordGuess. Choose your difficulty.\n1 - Easy(10 tries)\n2 - Intermediate(7 tries)\n3 - Hard(5 tries)");
           int choice = scan.nextInt();
           while (choice != 1 && choice != 2 && choice != 3) {
               System.out.printf("Invalid choice.\n Choose 1(Easy), 2(Intermediate), or 3(Hard).");
               choice = scan.nextInt();
           }
           if (choice == 1) {
               System.out.println("You have chosen easy.");
               remainingTries = 10;
           } else if (choice == 2) {
               System.out.println("You have chosen Intermediate.");
               remainingTries = 7;
           } else if (choice == 3) {
               System.out.println("You have chosen Hard.");
               remainingTries = 5;

           }


       }*/
//alternate code...
    public static void begin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to WordGuess. Choose your difficulty.");
        System.out.println("1 - Easy (10 tries)");
        System.out.println("2 - Intermediate (7 tries)");
        System.out.println("3 - Hard (5 tries)");

        int choice;
        while (true) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Choose 1 (Easy), 2 (Intermediate), or 3 (Hard).");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // Consume the invalid input
            }
        }

        switch (choice) {
            case 1:
                System.out.println("You have chosen easy.");
                remainingTries = 10;
                break;
            case 2:
                System.out.println("You have chosen Intermediate.");
                remainingTries = 7;
                break;
            case 3:
                System.out.println("You have chosen Hard.");
                remainingTries = 5;
                break;
        }
        System.out.printf("Do you know how to play?\n1 - Yes\n2 - No\n");
        choice = scan.nextInt();
        while (true) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (choice >= 1 && choice <= 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Choose 1 (Yes) or 2 (no).");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scan.next(); // uses a invalid input
            }
        }
        switch (choice) {
            case 1:
                System.out.println("Good luck! Lets get started...\n");
                game();
                break;
            case 2:
                System.out.printf("You will be given a Hidden word. Make a guess at the word one letter at a time.\n" +
                        "If your letter is in the word it will show up on the display. Used Letters will show on \n" +
                        "another line. Guess until you run out of tries!\n");
                game();
                break;
            default:
                System.out.println("Invalid choice. Starting the game by default...");
                game();
                break;
        }


    }

    public static void game() {
        Scanner scan = new Scanner(System.in);
        hangmanWord();
        System.out.println("");
        int usedTries = 0;

        while (usedTries < remainingTries) { //while the user has tries remaining this code runs
            String guess = scan.next().toUpperCase(); //makes all input upper case for comparing in the word bank
            guess = guess.substring(0, 1);

            while (!(guess.contains("A") || guess.contains("H") || guess.contains("O") || guess.contains("U") ||
                    guess.contains("B") || guess.contains("I") || guess.contains("P") || guess.contains("V") ||
                    guess.contains("C") || guess.contains("J") || guess.contains("Q") || guess.contains("W") ||
                    guess.contains("D") || guess.contains("K") || guess.contains("R") || guess.contains("X") ||
                    guess.contains("E") || guess.contains("L") || guess.contains("S") || guess.contains("Y") ||
                    guess.contains("F") || guess.contains("M") || guess.contains("T") || guess.contains("Z") ||
                    guess.contains("G") || guess.contains("N"))) {
                System.out.println("Invalid, please enter a letter.");// This whole thing checks to make sure user input
                guess = scan.next().toUpperCase();                    //is a letter. make more efficient later when I
            }                                                         //learn how to.
            while (used.contains(guess)) {
                System.out.println("Letter already guessed! Try another selection.");
                guess = scan.next().toUpperCase();
            }
            used = used + guess.substring(0, 1) + " ";  // This adds all the wrong guesses to a used list.

            while (!(guess.contains("A") || guess.contains("H") || guess.contains("O") || guess.contains("U") ||
                    guess.contains("B") || guess.contains("I") || guess.contains("P") || guess.contains("V") ||
                    guess.contains("C") || guess.contains("J") || guess.contains("Q") || guess.contains("W") ||
                    guess.contains("D") || guess.contains("K") || guess.contains("R") || guess.contains("X") ||
                    guess.contains("E") || guess.contains("L") || guess.contains("S") || guess.contains("Y") ||
                    guess.contains("F") || guess.contains("M") || guess.contains("T") || guess.contains("Z") ||
                    guess.contains("G") || guess.contains("N"))) {
                System.out.println("Invalid, please enter a letter.");         // we've seen this before
                guess = scan.next().toUpperCase();
            }
            boolean contain = false;
            boolean win = false;

            for(int i = 0;i< correctWord.length(); i++){     // If guess is correct, it puts the letter in the right spot
                if (correctWord.substring(i, i+1).contains(guess)){
                    word.set(i, guess);
                    contain = true;
                }
                System.out.print("");
            }

            if (contain == false){ //If the guess is wrong we add to tries
                for (int i = 0; i < correctWord.length(); i++){
                    System.out.print(word.get(i));
                }
                usedTries ++;
                System.out.println("\nIncorrect. Tries used: " + usedTries + "/" + remainingTries);
                System.out.println("Letters used:" + used);

            }
            if (contain == true){ //If the guess is right it prints word with new letter
                for (int i = 0; i < correctWord.length(); i++){
                    System.out.print(word.get(i));
                }

                System.out.println("\nCorrect. Tries used: " + usedTries + "/" + remainingTries);
                System.out.println("Letters used:" + used);

            }

            for (int i = 0; i < correctWord.length(); i++){  // sees if all letters are filled
                if (word.get(i) != "_"){  // if letter at i is guessed, win is true
                    win = true;
                }
                else {
                    win = false; // if the letter at is isn't guessed correct, false breaks from the loop
                    break; //exits the loop
                }
            }
            if ( win == true){ // if all the spaces are filled in with correct letter
                System.out.println("\nCongratulations! You Win. The word was " + correctWord + ".");
            }
        }
        // if player did not guess in the number of tries, they lose and are given the word
        System.out.println("\nCorrrect word was: " + correctWord + "\nYou ran out of tries. Try again!");

    }
}
