package com.company;

import java.util.Scanner;

public class Main {

    static String  word;

    public static void board(){
        Scanner s = new Scanner(System.in);
        //Contains the letter that will be guessed
        String lettersGuessed = " ";
        //Contains the word chosen by player in the beginning of the game
        word = (s.nextLine());

        //Registers letter (for it not to register more than once in the for loop)
        int letterRegistered = 0;
        //Amount of errors the player can make with his guesses
        int life = 5;
        //Once the player guesses all the letters in the word he will will
        int win = word.length();
        //Registers the input of the player put in the scanner
        String input;

        //Converts the word put in by the players into a char array
        char[] words = new char [word.length()];

        //Displays the word in dashes so the player does not know the word the he is to guess but it's length is made
        // clear for the player guessing
        char[] display = new char[word.length()];

        System.out.print("\n\n\n\n\n\n\n                                                                                   ");

        //Displays the word in dashes so the player does not know the word the he is to guess but it's length is made
        // clear for the player guessing
        for (int i = 0; i < word.length(); i++) {
            display[i] = '_';
            System.out.print(" " + display[i]);
        }

        //Converts the word put in by the players into a char array
        for (int i = 0; i < word.length(); i++){
            words[i] = word.charAt(i);
        }

        //Loop of the game
        while(life != 0 && win != 0){

            System.out.println("\n\n                                                                                     Guesses left: "
                    + life +  "\n\n                                                                                     Guess a letter: \n\n\n");

            //Letter guessed by player guessing
            input = s.nextLine();
            //if player puts more than one letter
            if(input.length() > 1){
                System.out.println("Put in only one letter!");
                life++;
            }
            //If player guessing guesses the same letter twice
            else if(checkDoubleGuess(lettersGuessed, input) >= 0){
                System.out.println("That was your guess " + checkDoubleGuess(lettersGuessed, input) + ". Guess another letter");
                life++;
            }
            //If player guesses a letter he hasn't guessed before
            else {
                for (int i = 0; i < word.length(); i++) {
                    //Loops for all the places there is the letter guessed in the word
                    if (input.equalsIgnoreCase(String.valueOf(words[i]))) {
                        display[i] = input.charAt(0);
                        //Adds one life because 1 life is taken at the end of the loop(to not lose a life if the right
                        // letter was guessed)
                        life++;
                        //Subtracts 1 for every letter found
                        win -= 1;
                    }
                    //Stores letter guess in 'letterGuessed'
                    else if (letterRegistered == 0) {
                        lettersGuessed = lettersGuessed + input + " ";
                        //letterRegistered++ for the letter not to register more than once in case there are more than
                        //one of that same letter
                        letterRegistered++;
                    }
                }
                //resets letterRegistered for the next loop
                letterRegistered -= 1;
            }
            System.out.print("                                                                                      ");
            for (int i = 0; i < word.length(); i++){
                System.out.print(display[i] + " ");
            }

            //Subtracts on life for player
            life -= 1;

            System.out.println("\nLetters guessed: " + lettersGuessed);

            //Game Over
            if (life == 0){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n                                                                                " + "GAME OVER");
            }

            //Game won
            if (win == 0){
                System.out.println("\n\n\n\n                                                                                   " + "YOU WIN" +
                        "\n\n\n\n");
            }
            }
        }

        public static int checkDoubleGuess(String lettersGuessed, String input) {

                int result = lettersGuessed.indexOf(input);
                return result;

        }

    public static void main(String[] args){

        System.out.println("Pick a word: \n");

        board();

    }

}




