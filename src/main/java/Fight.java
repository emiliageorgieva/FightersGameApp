import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fight {
    private List<Fighter> fighters;
    private List<Arena> arenas;
    private List<Fight> fights;
    private Fighter fighter1;
    private Fighter fighter2;
    private Arena arena;
    private Fighter winner;
    private Fighter loser;

    public Fight(Fighter fighter1, Fighter fighter2, Arena arena) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.arena = arena;

    }

    public Fight() {
        
    }

    public Fighter getFighter1() {
        return fighter1;
    }

    public Fighter getFighter2() {
        return fighter2;
    }

    public Arena getArena() {
        return arena;
    }

    public Fighter getWinner() {
        return winner;
    }

    public Fighter getLoser() {
        return loser;
    }

    public void startTournament() {
        System.out.println("Fight between " + fighter1.getClass().getSimpleName() + " and " +
                fighter2.getClass().getSimpleName() + " at " + arena.getName() + " arena begins now!");

        int maxTurns = 10; // Maximum number of turns for the battle
        int turn = 1; // Current turn

        while (turn <= maxTurns) {
            System.out.println("Round " + turn + ":");

            double dodgeChance2 = arena.getDodgeChance() + arena.getDodgeAdvantage();
            boolean dodgeSuccess2 = Math.random() < dodgeChance2;
            if (dodgeSuccess2) {
                System.out.println(fighter2.getClass().getSimpleName() + " successfully avoided the attack.");

            } else {
                // Fighter 1 attacks Fighter 2
                int damage1 = fighter1.calculateDamage();
                boolean criticalHit1 = fighter1.isCriticalHit();
                fighter2.takeDamage(damage1, criticalHit1);
                System.out.println(fighter1.getClass().getSimpleName() + " attacks " +
                        fighter2.getClass().getSimpleName() + " and deals " + damage1 + " damage.");
                System.out.println(fighter2.getClass().getSimpleName() + " remaining health: " + fighter2.getHealthPoints());

            }
            // Check if Fighter 2 is still alive
            if (!fighter2.isAlive()) {
                winner = fighter1;
                loser = fighter2;
                System.out.println(fighter2.getClass().getSimpleName() + " has been defeated.");
                break;
            }
            // Fighter 2 attacks Fighter 1
            int damage2 = fighter2.calculateDamage();
            boolean criticalHit2 = fighter2.isCriticalHit();
            fighter1.takeDamage(damage2, criticalHit2);
            System.out.println(fighter2.getClass().getSimpleName() + " attacks " +
                    fighter1.getClass().getSimpleName() + " and deals " + damage2 + " damage.");
            System.out.println(fighter1.getClass().getSimpleName() + " remaining health: " + fighter1.getHealthPoints());

            // Check if Fighter 1 is still alive
            if (!fighter1.isAlive()) {
                winner = fighter2;
                loser = fighter1;
                System.out.println(fighter1.getClass().getSimpleName() + " has been defeated.");
                break;
            }
            turn++;
        }
        // If the battle reached the maximum number of turns without a winner
        if (winner == null && loser == null) {
            System.out.println("The fight ended in a draw.");
        }
        System.out.println();

    }

    void generateBracket() {
        //randomly shuffle the fighters
        Random random = new Random();
        for (int i = fighters.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Fighter temporary = fighters.get(i);
            fighters.set(i, fighters.get(j));
            fighters.set(j, temporary);
        }
    }

    private void playTournament() {
        int numberOfRounds = (int) (Math.log(fighters.size()) / Math.log(2)); // number of rounds in a binary tournament
        for (int round = 0; round < numberOfRounds; round++) {
            List<Fighter> winners = new ArrayList<>();
            for (int i = 0; i < fighters.size() - 1; i += 2) {
                Fighter fighter1 = fighters.get(i);
                Fighter fighter2 = fighters.get(i + 1);

                Arena arena = getRandomArena();

                Fight fight = new Fight(fighter1, fighter2, arena);
                fight.startTournament();
                fights.add(fight);

                Fighter roundWinner = fight.getWinner();
                winners.add(roundWinner);
            }
            fighters = winners; // update the fighters for the next round
        }

        winner = fighters.get(0);
        loser = null; // Reset the loser, as there is no loser in the final round

    }

    private Arena getRandomArena() {
        Random random = new Random();
        int index = random.nextInt(arenas.size());
        return arenas.get(index);
    }

    private void displayResults() {
        System.out.println("Tournament Results: ");
        System.out.println("---------------------------");

        Fighter winner = fighters.get(0);
//        Fighter runnerUp = fights.get(fights.size()).getLoser();

        System.out.println("Winner: " + winner.getClass().getSimpleName());
//        System.out.println("Runner-up: " + runnerUp.getClass().getSimpleName());

        System.out.println("\nSummary of the Fights: ");
        System.out.println("---------------------------");

        for (int i = 0; i < fights.size(); i++) {
            Fight fight = fights.get(i);
            System.out.println("Fight " + (i + 1));
            System.out.println(fight.getFighter1().getClass().getSimpleName() + " vs. " + fight.getFighter2().getClass().getSimpleName());
            System.out.println("Arena: " + fight.getRandomArena().getName());
//            System.out.println("Number of turns: " + fight.getTurn());
//            System.out.println("Winner: " + fight.getWinner().getClass().getSimpleName());
//            System.out.println("Loser: " + fight.getLoser().getClass().getSimpleName());
            System.out.println();
        }
    }

    public void setFighters(List<Fighter> fighters) {
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setArenas(List<Arena> arenas) {
    }

    public List<Fight> getFights() {
        return fights;
    }

    public void setWinner(Fighter winner) {
    }

    public void setLoser(Fighter loser) {
    }
}
