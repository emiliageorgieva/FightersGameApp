import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private static final double DELTA = 0.001; // Tolerance for floating-point comparisons

    @Test
    public void testAttack() {
        Warrior warrior = new Warrior(100, 20, 10);
        Fighter opponent = new Warrior(100, 10, 5);

        int opponentInitialHealth = opponent.getHealthPoints();
        int rawDamage = warrior.attack(opponent);
        int opponentFinalHealth = opponent.getHealthPoints();

        Assertions.assertTrue(rawDamage > 0);
        Assertions.assertTrue(opponentFinalHealth < opponentInitialHealth);
    }

    @Test
    public void testDefend() {
        Warrior warrior = new Warrior(100, 20, 10);
        int rawDamage = 50;

        warrior.defend(rawDamage);

        Assertions.assertTrue(warrior.isAlive());
    }

    @Test
    public void testIsAlive() {
        Warrior warrior = new Warrior(100, 20, 10);

        Assertions.assertTrue(warrior.isAlive());

        warrior.defend(150);

        Assertions.assertFalse(warrior.isAlive());
    }

    @Test
    public void testCalculateRawDamage() {
        Warrior warrior = new Warrior(100, 20, 10);

        int rawDamage = warrior.calculateRawDamage();

        double lowerBound = 20 * 0.8; // 20 attackPoints * 80%
        double upperBound = 20 * 1.2; // 20 attackPoints * 120%

        Assertions.assertFalse(rawDamage >= lowerBound - DELTA && rawDamage <= upperBound + DELTA);
    }
    @Test
    public void testCalculateReducedDamage() {
        Warrior warrior = new Warrior(100, 20, 10);
        int rawDamage = 50;

        int reducedDamage = warrior.calculateReducedDamage(rawDamage);

        double lowerBound = rawDamage * 0.8; // 80% of rawDamage
        double upperBound = rawDamage * 1.2; // 120% of rawDamage

        Assertions.assertFalse(reducedDamage >= lowerBound - DELTA && reducedDamage <= upperBound + DELTA);
    }
}