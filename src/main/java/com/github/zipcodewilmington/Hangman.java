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
                "apple",
                "table",
                "music",
                "beach",
                "house",
                "happy",
                "pizza",
                "world",
                "glass",
                "earth"
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
    }







}
