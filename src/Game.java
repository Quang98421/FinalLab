import java.util.Scanner;

public class Game {
    public static Scanner scan = new Scanner(System.in);
    private static World world;
    private static Player player;
    
    public static void print(String message) {
        System.out.println(message);
    }
    
    public static void main(String[] args) {
        print("Welcome to the Haunted Lake House!");
        print("Find the key and escape... if you can!");
        print("\nCommands:");
        print("- north, south, east, west");
        print("- look");
        print("- take");
        print("- use");
        print("- inventory");
        print("- talk");
        print("- quit");
        
        world = new World();
        player = new Player();
        player.setCurrentRoom(world.getStartingRoom());
        
        boolean gameRunning = true;
        while (gameRunning) {
            player.getCurrentRoom().describe();
            System.out.print("\nWhat do you want to do? > ");
            String command = scan.nextLine().toLowerCase();
            
            switch (command) {
                case "north": case "n":
                    player.move("north");
                    break;
                case "south": case "s":
                    player.move("south");
                    break;
                case "east": case "e":
                    player.move("east");
                    break;
                case "west": case "w":
                    player.move("west");
                    break;
                case "look": case "l":
                    player.getCurrentRoom().describe();
                    break;
                case "inventory": case "i":
                    player.showInventory();
                    break;
                case "take":
                    print("What do you want to take?");
                    String itemName = scan.nextLine().toLowerCase();
                    player.takeItem(itemName);
                    break;
                case "use":
                    print("What do you want to use?");
                    String useItem = scan.nextLine().toLowerCase();
                    player.useItem(useItem);
                    break;
                case "talk":
                    NPC npc = player.getCurrentRoom().getNPC();
                    if (npc != null) {
                        npc.talk();
                    } else {
                        print("Nobody here to talk to!");
                    }
                    break;
                case "quit":
                    gameRunning = false;
                    print("Thanks for playing!");
                    break;
                default:
                    print("I don't understand that.");
            }
        }
    }
}