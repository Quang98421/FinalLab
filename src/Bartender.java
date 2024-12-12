public class Bartender extends NPC {
    private int talkCount;
    private boolean candleLit;
    
    public Bartender() {
        super("Ghost");
        talkCount = 0;
        candleLit = false;
    }
    
    
    public void talk() {
        talkCount++;
        
        if (talkCount == 1) {
            Game.print("\nGhost: Who dares enter my bar?");
            Game.print("1. Ask for help");
            Game.print("2. Run away");
            
            int choice = Game.scan.nextInt();
            Game.scan.nextLine();
            
            if (choice == 1) {
                Game.print("Ghost: Light the candle first...");
            } else {
                Game.print("Ghost: Hehe... they always run!");
            }
        }
        else if (candleLit) {
            Game.print("Ghost: You lit the candle! Here's the key.");
            Player player = new Player();
            player.giveKey();
        }
        else {
            Game.print("Ghost: No candle, no key!");
        }
    }
    
    public void setCandleLit(boolean lit) {
        candleLit = lit;
    }
}