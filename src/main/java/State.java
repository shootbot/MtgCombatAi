import java.util.*;

public class State {
    private static Random rng = new Random();
    
    private List<Creature> blueCreatures = new ArrayList<>();
    private List<Creature> redCreatures = new ArrayList<>();
    private int blueLife = 20;
    private int redLife = 20;
    
    private int turn; // even blue turn, odd red turn
    private Step step;
    
    public State() {
        step = Step.UNTAP;
    }
    
    private void moveStep() {
        switch (step) {
            case UNTAP:
                step = Step.UPKEEP;
                break;
            case UPKEEP:
                step = Step.DRAW;
                break;
            case DRAW:
                step = Step.M1;
                break;
            case M1:
                step = Step.COMBAT_START;
                break;
            case COMBAT_START:
                step = Step.DECLARE_ATTACKERS;
                break;
            case DECLARE_ATTACKERS:
                step = Step.DECLARE_BLOCKERS;
                break;
            case DECLARE_BLOCKERS:
                step = Step.FIRST_DAMAGE;
                break;
            case FIRST_DAMAGE:
                step = Step.NORMAL_DAMAGE;
                break;
            case NORMAL_DAMAGE:
                step = Step.COMBAT_FINISH;
                break;
            case COMBAT_FINISH:
                step = Step.M2;
                break;
            case M2:
                step = Step.END;
                break;
            case END:
                step = Step.CLEANUP;
                break;
            case CLEANUP:
                step = Step.UNTAP;
                turn++;
                break;
        }
    }
    
    private Card draw() {
        double random = rng.nextDouble();
        
        if (random < 0.3) return Card.createLand();
//        if (random < 0.5) return Card.createCreature(2, 2, true);
        if (random < 0.5) return Card.createCreature(2, 2);
        if (random < 0.7) return Card.createCreature(3, 3);
        if (random < 0.9) return Card.createCreature(4, 4);
        return Card.createCreature(5, 5);
        
    }
}
