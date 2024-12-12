public class Candle extends Item {
    private boolean isLit;
    
    public Candle() {
        super("candle", "A strange candle");
        isLit = false;
    }
    
    
    public void use(Player player) {
        if (!isLit) {
            Game.print("You lit the candle!");
            Game.print("The ghost seems friendlier!");
            isLit = true;
        } else {
            Game.print("The candle is already lit!");
        }
    }
}