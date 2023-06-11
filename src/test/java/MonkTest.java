import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkTest {
    private Monk monk;

    @BeforeEach
    void setUp() {
        monk = new Monk(100, 10, 5);
    }


    @Test
    public void testAttack() {
        Monk monk = new Monk(100, 20, 10);
        Fighter opponent = new Monk(100, 10, 5);

        int opponentInitialHealth = opponent.getHealthPoints();
        int rawDamage = monk.attack(opponent);
        int opponentFinalHealth = opponent.getHealthPoints();

        Assertions.assertTrue(rawDamage > 0);
        Assertions.assertTrue(opponentFinalHealth < opponentInitialHealth);
    }

    @Test
    public void testDefend() {
        Monk monk = new Monk(100, 20, 10);
        int rawDamage = 50;

        monk.defend(rawDamage);

        Assertions.assertTrue(monk.isAlive());
    }

    @Test
    public void testIsAlive() {
        Monk monk = new Monk(100, 20, 10);

        Assertions.assertTrue(monk.isAlive());

        monk.defend(150);

        Assertions.assertFalse(monk.isAlive());
    }

    @Test
    public void testCalculateRawDamage() {
        Monk monk = new Monk(100, 20, 10);

        int rawDamage = monk.calculateRawDamage();

        Assertions.assertTrue(rawDamage >= 24 && rawDamage <= 36);
    }

    @Test
    public void testCalculateReducedDamage() {
        Monk monk = new Monk(100, 20, 10);
        int rawDamage = 50;

        int reducedDamage = monk.calculateReducedDamage(rawDamage);

        int lowerBound = (int) (rawDamage * 0.8); // 80% of rawDamage
        int upperBound = (int) (rawDamage * 1.2); // 120% of rawDamage

        Assertions.assertFalse(reducedDamage >= lowerBound && reducedDamage <= upperBound);
    }

}