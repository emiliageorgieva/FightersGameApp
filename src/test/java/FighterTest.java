import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterTest {
    @Test
    public void testAttack() {
        Arena arena = new Arena("Temple", 0.0, 0.2); // Assume a damage advantage of 20%
        Fighter fighter1 = new Knight(100, 20, 10);
        Fighter fighter2 = new Assassin(100, 15, 5);

        int damage = fighter1.attack(fighter2);

        // Check if the damage is calculated correctly
        Assertions.assertTrue(damage >= 24 && damage <= 31);
    }
    @Test
    public void testDefend() {
        Fighter fighter = new Knight(100, 20, 10);
        int initialHealth = fighter.getHealthPoints();

        // Simulate an incoming raw damage of 15
        fighter.defend(15);

        // Check if the fighter's health has decreased correctly
        Assertions.assertTrue(fighter.getHealthPoints() < initialHealth && fighter.getHealthPoints() >= 0);
    }
    @Test
    public void testIsAlive() {
        Fighter fighter = new Knight(100, 20, 10);

        // Initially, the fighter should be alive
        Assertions.assertTrue(fighter.isAlive());

        // Set the fighter's health to zero
        fighter.takeDamage(fighter.getHealthPoints(), false);

        // After taking damage, the fighter should be dead
        Assertions.assertFalse(fighter.isAlive());
    }
    @Test
    public void testCalculateDamage() {
        Fighter fighter = new Knight(100, 20, 10);

        // Calculate damage
        int damage = fighter.calculateDamage();

        // Check if the calculated damage is within the expected range
        Assertions.assertTrue(damage >= 24 && damage <= 36);

    }
    @Test
    public void testIsCriticalHit() {
        Fighter fighter = new Knight(100, 20, 10);

        // The Knight class does not have a critical hit ability
        // Therefore, isCriticalHit() should always return false
        Assertions.assertFalse(fighter.isCriticalHit());
    }





}