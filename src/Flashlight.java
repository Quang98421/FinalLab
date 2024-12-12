public class Flashlight extends Item {
    private boolean isOn;
    
    public Flashlight() {
        super("flashlight", "An old flashlight");
        isOn = false;
    }
    
    
    public void use(Player player) {
        isOn = !isOn;
        if (isOn) {
            Game.print("You turned on the flashlight!");
            if (player.getCurrentRoom().getName().equals("Basement")) {
                Game.print("You can see a door now!");
            }
        } else {
            Game.print("You turned off the flashlight!");
        }
    }
}