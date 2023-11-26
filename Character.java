// Character.java - Class representing characters in the game

public class Character {
    private String name;
    private int health;
    private String weapon;
    private int attackPower;
    private String specialMove;

    // Constructor for the Character class
    public Character(String name, int health, String weapon, int attackPower, String specialMove) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.attackPower = attackPower;
        this.specialMove = specialMove;
    }

    // Method to display character info
    public void displayCharacterInfo() {
        System.out.println("Character Name: " + name);
        System.out.println("Health Points: " + health);
        System.out.println("Weapon: " + weapon);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Special Move: " + specialMove);
    }

    // Method for character to perform an attack
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + " with " + weapon + " using " + specialMove);
        target.takeDamage(attackPower);
    }

    // Method for character to take damage
    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " takes " + damage + " points of damage.");
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    // Getters and setters for character attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getSpecialMove() {
        return specialMove;
    }

    public void setSpecialMove(String specialMove) {
        this.specialMove = specialMove;
    }
}