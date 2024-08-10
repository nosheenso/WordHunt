# Word Hunt

## Introduction

Wordle is a word-guessing game that combines elements of hangman and Mastermind. In Wordle, you have a limited number of attempts to guess a hidden word. With each guess, you receive feedback about how your guess relates to the mystery word. The letters in your guess are labeled as correct, used, or unused. Your objective is to guess the mystery word with the fewest attempts.

## Learning Outcomes

In this assignment, you will gain experience with the following concepts:

- Creating a subclass
- Overriding methods
- Using `instanceof` to determine object class
- Utilizing Generics
- Working with linked data structures
- Using loops and conditionals

## Provided Files

The following files are provided for this assignment:

- `LinearNode.java` (from the course materials)
- `TestWordLL.java` (test cases for checking your code)
- `WordLLExamples.java` (examples demonstrating your code usage)
- `words` (a text file containing a list of words, if applicable)

## Classes to Implement

For this assignment, you must implement the following Java classes:

- `Letter`: Represents a single letter used in the game.
- `Word`: Represents a word in the game, composed of letters.
- `WordLL`: A central repository for information about a Wordle game.

Each class has specific requirements, and you should refer to the assignment instructions for details.

## Installation

If you want to run this project on your local machine, follow these steps:

1. Clone this repository to your local system.
2. Make sure you have Java installed.
3. Compile the code if needed (e.g., `javac MyWordleGame.java`).
4. Run the program (e.g., `java MyWordleGame`).

## Usage

### Running the Game

To run the Wordle game, you can create instances of the `WordLL` class, providing guesses and checking the results. Here's an example:

```java
public static void main(String[] args) {
    Word mysteryWord = new Word(Word.fromString("ORDER"));
    WordLL game = new WordLL(mysteryWord);
    
    Word guess1 = new Word(Word.fromString("BEAR"));
    Word guess2 = new Word(Word.fromString("REJECT"));
    Word guess3 = new Word(Word.fromString("SHORE"));
    
    System.out.println("Word: " + guess1.toString());
    System.out.println("Word: " + guess2.toString());
    System.out.println("Word: " + guess3.toString());
    
    boolean isCorrect = game.tryWord(guess3);
    if (isCorrect) {
        System.out.println("You got it!");
    }
}
