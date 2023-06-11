public abstract class Fighter {
    protected int healthPoints;
    protected int attackPoints;
    protected int armorPoints;
    protected boolean alive;
    Fighter winner;

    public Fighter(int healthPoints, int attackPoints, int armorPoints) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.armorPoints = armorPoints;
        this.alive = true;
    }

    private Arena arena;

    public Arena getArena() {
        return arena;
    }

    public int attack(Fighter opponent) {
        double rawDamage = calculateDamage();

        //apply damage advantage based on the location
        double damageAdvantage = opponent.getArena().getDamageAdvantage();
        double finalDamage = rawDamage + (rawDamage * damageAdvantage);

        //apply damage to the opponent
        opponent.takeDamage((int) finalDamage, isCriticalHit());
        double damage = attackPoints * opponent.getArena().getDamageAdvantage();
        if (this instanceof Knight && Math.random() < 0.1) {
            // Knight has a 10% chance to do 200% damage
            damage *= 2;
        } else if (this instanceof Assassin && Math.random() < 0.3) {
            // Assassin has a 30% chance to do 300% damage
            damage *= 3;
        }// Round the damage to the nearest integer
        int roundedDamage = (int) Math.round(damage);
        // Return the calculated damage
        return roundedDamage;
    }

    public abstract void defend(int rawDamage);

    public boolean isAlive() {
        return alive;
    }

    public void takeDamage(int damage, boolean isCriticalHit) {
        int reducedDamage = isCriticalHit ? damage : (int) (damage * (Math.random() * 0.8 + 1.2));
        healthPoints -= reducedDamage;

        if (healthPoints <= 0) {
            healthPoints = 0;
            alive = false;
        }
    }

    public boolean isCriticalHit() {
        return false;
    }

    public int calculateDamage() {
        double damageMultiplier = Math.random() * 0.8 + 1.2;
        int rawDamage = (int) (attackPoints * damageMultiplier);
        return isCriticalHit() ? rawDamage * 2 : rawDamage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int i) {
    }
}
