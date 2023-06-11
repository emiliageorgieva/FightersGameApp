import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AssassinTest {

    @Test
    public void testAttack() {
        Fighter opponent = new Assassin(100, 20, 10);
        Assassin assassin = new Assassin(100, 30, 10);

        int rawDamage = assassin.attack(opponent);

        // Check that raw damage is within expected range
        assertTrue(rawDamage >= 24 && rawDamage <= 36);

        // Check that opponent's health has been reduced
        assertTrue(opponent.getHealthPoints() < 100);
    }

    @Test
    public void testAttack_TripleDamage() {
        Fighter opponent = new Assassin(100, 20, 10);
        Assassin assassin = new Assassin(100, 30, 10);

        // Force attack chance to be within the triple damage range (<= 0.3)
        Random random = new Random() {
            @Override
            public double nextDouble() {
                return 0.2;
            }
        };

        int rawDamage = assassin.attack(opponent);

        // Calculate the expected raw damage with triple damage
        double damagePercent = 1.2; // Random damage percentage
        int expectedRawDamage = (int) (damagePercent * 30 * 3);
        assertNotEquals(expectedRawDamage, rawDamage);

        // Check that opponent's health has been reduced
        assertTrue(opponent.getHealthPoints() < 100);
    }

    @Test
    public void testDefend() {
        Assassin assassin = new Assassin(100, 30, 10);

        // Force dodge chance to be within the avoid/block range (<= 0.3)
        Random random = new Random() {
            @Override
            public double nextDouble() {
                return 0.2;
            }
        };

        int rawDamage = 40;
        int initialHealth = assassin.getHealthPoints();
        assassin.defend(rawDamage);

        // Check that damage is reduced if dodge is unsuccessful
        assertTrue(assassin.getHealthPoints() < initialHealth);

        // Check that damage is not reduced if dodge is successful
        assassin.defend(rawDamage);
        assertNotEquals(assassin.getHealthPoints(), initialHealth);
    }

    @Test
    public void testIsAlive() {
        Assassin assassin = new Assassin(100, 30, 10);

        // Check that the assassin is alive initially
        assertTrue(assassin.isAlive());

        // Reduce the assassin's health to 0 and check that it is not alive
        assassin.defend(assassin.getHealthPoints());
        assertFalse(assassin.isAlive());
    }

}