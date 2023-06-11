public class Arena {
    private String name;
    private double dodgeAdvantage;
    private double damageAdvantage;

    public Arena(String name, double dodgeAdvantage, double damageAdvantage) {
        this.name = name;
        this.dodgeAdvantage = dodgeAdvantage;
        this.damageAdvantage = damageAdvantage;
    }

    public String getName() {
        return name;
    }

    public double getDodgeAdvantage() {
        // Logic to determine the dodge advantage based on the location
        if (name.equals("Temple")) {
            return 0.1; // Temple location provides a dodge advantage of 0.1 (10%)
        } else if (name.equals("Castle")) {
            return 0.0; // Castle location provides no dodge advantage
        } else if (name.equals("Battlefield")) {
            return 0.0; // Battlefield location provides no dodge advantage
        } else if (name.equals("Woods")) {
            return 0.2; // Woods location provides a dodge advantage of 0.2 (20%)
        } else {
            return 0.0; // Default dodge advantage (if location is not recognized)
        }
    }

    public double getDamageAdvantage() {
        // Logic to determine the damage advantage based on the location
        if (name.equals("Temple")) {
            return 0.0; // Temple location provides no damage advantage
        } else if (name.equals("Castle")) {
            return 0.0; // Castle location provides no damage advantage
        } else if (name.equals("Battlefield")) {
            return 0.5; // Battlefield location provides a damage advantage of 0.5 (50%)
        } else if (name.equals("Woods")) {
            return 0.0; // Woods location provides no damage advantage
        } else {
            return 0.0; // Default damage advantage (if location is not recognized)
        }
    }

    public double getDodgeChance() {
        // Logic to determine the dodge chance based on the location
        if (name.equals("Temple")) {
            return 0.1; // Temple location provides a dodge chance of 0.1 (10%)
        } else if (name.equals("Castle")) {
            return 0.0; // Castle location provides no dodge chance
        } else if (name.equals("Battlefield")) {
            return 0.0; // Battlefield location provides no dodge chance
        } else if (name.equals("Woods")) {
            return 0.0; // Woods location provides no dodge chance
        } else {
            return 0.0; // Default dodge chance (if location is not recognized)
        }
    }
}


