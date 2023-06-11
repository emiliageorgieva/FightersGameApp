import java.util.Random;

public class Assassin extends Fighter {
    public Assassin(int healthPoints, int attackPoints, int armorPoints) {
        super(healthPoints, attackPoints, armorPoints);
    }

    @Override
    public int attack(Fighter opponent) {
        Random random = new Random();
        double attackChance = random.nextDouble();
        int rawDamage = calculateRawDamage();
        if (attackChance <= 0.3) { //30% chance to do triple damage /300%
            rawDamage *= 3;
        }
        opponent.defend(rawDamage);
        return rawDamage;
    }

    @Override
    public void defend(int rawDamage) {
        Random random = new Random();
        double dodgeChance = random.nextDouble();
        if (dodgeChance <= 0.3) { // 30% chance to avoid/block the attack
            return; // receive no damage
        }
        int reducedDamage = calculateReducedDamage(rawDamage);
        healthPoints -= reducedDamage;
    }

    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    private int calculateRawDamage() {
        Random random = new Random();
        double damagePercent = random.nextDouble() * 0.8 + 1.2; // between 80% and 120%
        return (int) (damagePercent * attackPoints);
    }

    private int calculateReducedDamage(int rawDamage) {
        Random random = new Random();
        double reductionPercent = random.nextDouble() * 0.8 + 1.2; // between 80% and 120%
        return (int) (reductionPercent * rawDamage);
    }
}
