// Puzzle.java - Class for puzzle mechanics in the game

public class Puzzle {
    private String question;
    private String answer;
    private boolean isSolved;

    // Constructor for Puzzle class
    public Puzzle(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isSolved = false;
    }

    // Method to display the puzzle question to the player
    public void displayPuzzle() {
        System.out.println("Puzzle: " + question);
    }

    // Method to check the player's answer
    public boolean checkAnswer(String playerAnswer) {
        if (playerAnswer.equalsIgnoreCase(answer)) {
            System.out.println("Correct answer! You have solved the puzzle.");
            isSolved = true;
            return true;
        } else {
            System.out.println("Incorrect answer. Try again.");
            return false;
        }
    }

    // Method to determine if the puzzle has been solved
    public boolean isSolved() {
        return isSolved;
    }

    // Getter method for the puzzle question
    public String getQuestion() {
        return question;
    }

    // Setter method for the puzzle question
    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter method for the puzzle answer
    public String getAnswer() {
        return answer;
    }

    // Setter method for the puzzle answer
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}