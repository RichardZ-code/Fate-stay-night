// GameEngine.java - Main class for handling the game mechanics and flow

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameEngine {
    private Character playerCharacter;
    private Character enemyCharacter;
    private InventoryItem inventoryItem;
    private Puzzle gamePuzzle;
    private boolean gameRunning;

    public GameEngine() {
        // Initialize the game with default settings
        playerCharacter = new Character("Player", 100, "Sword", 10, "Power Strike");
        enemyCharacter = new Character("Enemy", 80, "Axe", 8, "Fury Slash");
        inventoryItem = new InventoryItem("Health Potion", "Health", 20);
        gamePuzzle = new Puzzle("What walks on four legs in the morning, two legs at noon, and three legs in the evening?", "Human");
        gameRunning = true;
    }

    // Method to start the game
    public void startGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Fate/stay night - The Adventure Begins!");

        while (gameRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Explore");
            System.out.println("2. View Character");
            System.out.println("3. Use Item");
            System.out.println("4. Solve Puzzle");
            System.out.println("5. Exit Game");

            String input = reader.readLine();
            switch (input) {
                case "1":
                    explore();
                    break;
                case "2":
                    playerCharacter.displayCharacterInfo();
                    break;
                case "3":
                    inventoryItem.use(playerCharacter);
                    break;
                case "4":
                    solvePuzzle(reader);
                    break;
                case "5":
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid action.");
            }

            // Check game status
            if (!playerCharacter.isAlive()) {
                System.out.println("Game Over. You have been defeated.");
                gameRunning = false;
            }
        }

        System.out.println("Thank you for playing Fate/stay night!");
    }

    // Method for the explore option
    private void explore() {
        System.out.println("You explore the surroundings and encounter an enemy!");
        battle();
    }

    // Method to handle battles
    private void battle() {
        playerCharacter.attack(enemyCharacter);
        if (enemyCharacter.isAlive()) {
            enemyCharacter.attack(playerCharacter);
        }
    }

    // Method to solve puzzles
    private void solvePuzzle(BufferedReader reader) throws IOException {
        gamePuzzle.displayPuzzle();
        System.out.println("Enter your answer: ");
        String answer = reader.readLine();
        gamePuzzle.checkAnswer(answer);
    }

    // Main method to run the game
    public static void main(String[] args) throws IOException {
        GameEngine game = new GameEngine();
        game.startGame();
    }
}