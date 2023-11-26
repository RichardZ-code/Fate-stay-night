// InventoryItem.java - Class representing items in the game's inventory

public class InventoryItem {
    private String itemName;
    private String itemType;
    private int effectValue;

    // Constructor for the InventoryItem class
    public InventoryItem(String itemName, String itemType, int effectValue) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.effectValue = effectValue;
    }

    // Method to use the item on a character
    public void use(Character character) {
        if (itemType.equalsIgnoreCase("Health Potion")) {
            character.setHealth(character.getHealth() + effectValue);
            System.out.println(character.getName() + " used a " + itemName + " and recovered " + effectValue + " health points.");
        }
        // Additional item types and effects can be added here
    }

    // Getter method for the item name
    public String getItemName() {
        return itemName;
    }

    // Setter method for the item name
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter method for the item type
    public String getItemType() {
        return itemType;
    }

    // Setter method for the item type
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    // Getter method for the effect value
    public int getEffectValue() {
        return effectValue;
    }

    // Setter method for the effect value
    public void setEffectValue(int effectValue) {
        this.effectValue = effectValue;
    }
}