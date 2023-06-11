import java.util.Random;

public class Knight extends Fighter {
    public Knight(int healthPoints, int attackPoints, int armorPoints) {
        super(healthPoints, attackPoints, armorPoints);
    }

    @Override
    public int attack(Fighter opponent) {
        Random random = new Random();
        double attackChance = random.nextDouble();
        int rawDamage = calculateRawDamage();
        if (attackChance <= 0.1) { // 10% chance to do 200% /double damage
            rawDamage *= 2;
        }
        opponent.defend(rawDamage);
        return rawDamage;
    }

    @Override
    public void defend(int rawDamage) {
        Random random = new Random();
        double blockChance = random.nextDouble();
        if (blockChance <= 0.2) { // 20% chance to block the attack
            return; //receive no damage
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
