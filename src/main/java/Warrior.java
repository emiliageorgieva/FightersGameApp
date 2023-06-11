import java.util.Random;

public class Warrior extends Fighter {

    public Warrior(int healthPoints, int attackPoints, int armorPoints) {
        super(healthPoints, attackPoints, armorPoints);
    }

    @Override
    public int attack(Fighter opponent) {
        int rawDamage = calculateRawDamage();
        opponent.defend(rawDamage);
        System.out.println("Warrior fighter is attacking!");
        return rawDamage;
    }

    @Override
    public void defend(int rawDamage) {
        System.out.println("Warrior fighter defended himself!");
        int reducedDamage = calculateReducedDamage(rawDamage);
        healthPoints -= reducedDamage;

    }

    @Override
    public boolean isAlive() {
        System.out.println("Warrior fighter is still Alive!");
        return healthPoints > 0;
    }

    int calculateRawDamage() {
        System.out.println("Warrior fighter's health is being randomly reduced within 80%-120%.");
        Random random = new Random();
        double damagePercent = random.nextDouble() * 0.8 + 1.2; // between 80% and 120%
        return (int) (damagePercent * attackPoints);
    }

    int calculateReducedDamage(int rawDamage) {
        System.out.println("Warrior fighter's damage is reduced with ");
        Random random = new Random();
        double reductionPercent = random.nextDouble() * 0.8 + 1.2; // between 80% and 120%
        return (int) (reductionPercent * rawDamage);
    }
}
