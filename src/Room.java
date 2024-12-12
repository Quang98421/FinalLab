import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north, south, east, west;
    private ArrayList<Item> items;
    private NPC npc;
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<Item>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setExits(Room north, Room south, Room east, Room west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    
    public Room getNorth() { return north; }
    public Room getSouth() { return south; }
    public Room getEast() { return east; }
    public Room getWest() { return west; }
    
    public void setNPC(NPC npc) {
        this.npc = npc;
    }
    
    public NPC getNPC() {
        return npc;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }
    
    public void describe() {
        Game.print("\n[" + name + "]");
        Game.print(description);
        
        if (!items.isEmpty()) {
            Game.print("\nYou see:");
            for (Item item : items) {
                Game.print("- " + item.getName());
            }
        }
        
        if (npc != null) {
            Game.print("\nSomeone is here:");
            Game.print("- " + npc.getName());
        }
        
        Game.print("\nExits: " + getExits());
    }
    
    private String getExits() {
        StringBuilder exits = new StringBuilder();
        if (north != null) exits.append("north ");
        if (south != null) exits.append("south ");
        if (east != null) exits.append("east ");
        if (west != null) exits.append("west ");
        return exits.toString();
    }
}