import java.util.Random;

public class Monk extends Fighter {
    public Monk(int healthPoints, int attackPoints, int armorPoints) {
        super(healthPoints, attackPoints, armorPoints);
    }

    @Override
    public int attack(Fighter opponent) {
        int rawDamage = calculateRawDamage();
        opponent.defend(rawDamage);
        System.out.println("Monk fighter attacked!");
        return rawDamage;
    }

    @Override
    public void defend(int rawDamage) {
        System.out.println("Monk fighter just defended himself!");
        Random random = new Random();
        double avoidChance = random.nextDouble();
        if (avoidChance <= 0.3) { //30% chance to avoid the attack
            return; //receive no damage
        }
        int reducedDamage = calculateReducedDamage(rawDamage);
        healthPoints -= reducedDamage;
    }

    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    int calculateRawDamage() {
        Random random = new Random();
        double damagePercent = random.nextDouble() * 0.8 + 1.2; // between 80% and 120%
        return (int) (damagePercent * attackPoints);
    }

    int calculateReducedDamage(int rawDamage) {
        Random random = new Random();
        double reductionPercent = random.nextDouble() * 0.8 + 1.2; // between 80% and 120%
        return (int) (reductionPercent * rawDamage);
    }
}
