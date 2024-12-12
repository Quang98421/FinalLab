import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private boolean hasKey;
    
    public Player() {
        inventory = new ArrayList<Item>();
        hasKey = false;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
    
    public void move(String direction) {
        Room nextRoom = null;
        
        if (direction.equals("north")) {
            nextRoom = currentRoom.getNorth();
        } else if (direction.equals("south")) {
            nextRoom = currentRoom.getSouth();
        } else if (direction.equals("east")) {
            nextRoom = currentRoom.getEast();
        } else if (direction.equals("west")) {
            nextRoom = currentRoom.getWest();
        }
        
        if (nextRoom == null) {
            Game.print("You can't go that way!");
        } else {
            currentRoom = nextRoom;
            if (hasKey && currentRoom.getName().equals("Basement")) {
                Game.print("\nYou use the key on the door...");
                Game.print("It works! You escaped!");
                Game.print("You win!");
                System.exit(0);
            }
        }
    }
    
    public void takeItem(String itemName) {
        Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            inventory.add(item);
            Game.print("You took the " + itemName);
        } else {
            Game.print("There's no " + itemName + " here!");
        }
    }
    
    public void useItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                item.use(this);
                return;
            }
        }
        Game.print("You don't have a " + itemName + "!");
    }
    
    public void showInventory() {
        if (inventory.isEmpty()) {
            Game.print("Your inventory is empty!");
        } else {
            Game.print("\nYou are carrying:");
            for (Item item : inventory) {
                Game.print("- " + item.getName());
            }
        }
    }
    
    public void giveKey() {
        hasKey = true;
        Game.print("You got the key to escape!");
    }
}