

public class Creature {
    public int power;
    public int toughness;
    public boolean tapped;
    public boolean flying;
    
    public Creature(int power, int toughness) {
        this.power = power;
        this.toughness = toughness;
    }
    
    public Creature(int power, int toughness, boolean flying) {
        this(power, toughness);
        this.flying = flying;
    }
}
