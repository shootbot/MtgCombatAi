

public class Card {
    CardType type;
    int power;
    int toughness;
    boolean flying;
    
    private Card(CardType type) {
        this.type = type;
    }
    
    private Card(int power, int toughness, boolean flying) {
        this.power = power;
        this.toughness = toughness;
        this.flying = flying;
    }
    
    public static Card createLand() {
        return new Card(CardType.LAND);
    }
    
    public static Card createCreature(int power, int toughness, boolean flying) {
        return new Card(power, toughness, flying);
        
    }
}
