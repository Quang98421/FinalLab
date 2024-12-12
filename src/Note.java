public class Note extends Item {
    public Note() {
        super("note", "An old piece of paper");
    }
    
    public void use(Player player) {
        Game.print("The note says:");
        Game.print("'Light the candle to calm the ghost.'");
        Game.print("'Get the key from him to escape.'");
    }
}