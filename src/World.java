public class World {
    private Room startingRoom;
    
    public World() {
        createWorld();
    }
    
    private void createWorld() {
        Room entrance = new Room("Entrance", "A spooky entrance room.");
        Room living = new Room("Living Room", "A dusty room with old furniture.");
        Room kitchen = new Room("Kitchen", "A creepy old kitchen.");
        Room bar = new Room("Bar", "An abandoned bar room.");
        Room basement = new Room("Basement", "A dark basement.");
        
        entrance.setExits(living, null, kitchen, null);
        living.setExits(null, entrance, bar, null);
        kitchen.setExits(bar, null, null, entrance);
        bar.setExits(null, kitchen, null, living);
        basement.setExits(bar, null, null, null);
        
        entrance.addItem(new Flashlight());
        living.addItem(new Note());
        kitchen.addItem(new Candle());
        
        bar.setNPC(new Bartender());
        
        startingRoom = entrance;
    }
    
    public Room getStartingRoom() {
        return startingRoom;
    }
}