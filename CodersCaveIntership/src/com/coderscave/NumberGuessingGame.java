package com.coderscave;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;  // Change this to set your desired range
        int upperBound = 100;  // Change this to set your desired range
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int numberOfTries = 0;
        boolean GuessedCorrectly = false;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

        while (!GuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            numberOfTries++;

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please guess within the specified range.");
            } 
            else if (userGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } 
            else if (userGuess > numberToGuess) {
                System.out.println("Try a lower number.");
            } 
            else {
                GuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + numberOfTries + " tries!");
            }
        }

        sc.close();
    }
}