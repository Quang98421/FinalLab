public class NPC {
    private String name;
    
    public NPC(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void talk() {
        Game.print("They don't want to talk.");
    }
}