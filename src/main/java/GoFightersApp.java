import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoFightersApp {
    public static void main(String[] args) {
        // Create fighters
        Fighter warrior1 = new Warrior(100, 20, 10);
        Fighter warrior2 = new Warrior(120, 18, 12);
        Fighter knight1 = new Knight(110, 25, 15);
        Fighter knight2 = new Knight(100, 22, 13);
        Fighter assassin1 = new Assassin(90, 15, 8);
        Fighter assassin2 = new Assassin(95, 16, 9);
        Fighter monk1 = new Monk(80, 12, 6);
        Fighter monk2 = new Monk(85, 14, 7);

        // Demonstrate battle between fighters in different arenas
        Fight fight1 = new Fight(warrior1, knight1, getRandomArena());
        fight1.startTournament();

        Fight fight2 = new Fight(assassin1, monk1, getRandomArena());
        fight2.startTournament();

        Fight fight3 = new Fight(warrior2, assassin2, getRandomArena());
        fight3.startTournament();

        Fight fight4 = new Fight(knight2, monk2, getRandomArena());
        fight4.startTournament();

        // Display fight results
        System.out.println("Fight 1:");
        System.out.println("Fighter 1: " + fight1.getFighter1().getClass().getSimpleName());
        System.out.println("Fighter 2: " + fight1.getFighter2().getClass().getSimpleName());
        System.out.println("Location: " + fight1.getArena().getName() + " arena");
        System.out.println("Winner: " + fight1.getWinner().getClass().getSimpleName());
        System.out.println("Loser: " + fight1.getLoser().getClass().getSimpleName());
        System.out.println();

        System.out.println("Fight 2:");
        System.out.println("Fighter 1: " + fight2.getFighter1().getClass().getSimpleName());
        System.out.println("Fighter 2: " + fight2.getFighter2().getClass().getSimpleName());
        System.out.println("Location: " + fight2.getArena().getName() + " arena");
        System.out.println("Winner: " + fight2.getWinner().getClass().getSimpleName());
        System.out.println("Loser: " + fight2.getLoser().getClass().getSimpleName());
        System.out.println();

        System.out.println("Fight 3:");
        System.out.println("Fighter 1: " + fight3.getFighter1().getClass().getSimpleName());
        System.out.println("Fighter 2: " + fight3.getFighter2().getClass().getSimpleName());
        System.out.println("Location: " + fight3.getArena().getName() + " arena");
        System.out.println("Winner: " + fight3.getWinner().getClass().getSimpleName());
        System.out.println("Loser: " + fight3.getLoser().getClass().getSimpleName());
        System.out.println();

        System.out.println("Fight 4:");
        System.out.println("Fighter 1: " + fight4.getFighter1().getClass().getSimpleName());
        System.out.println("Fighter 2: " + fight4.getFighter2().getClass().getSimpleName());
        System.out.println("Location: " + fight4.getArena().getName() + " arena");
        System.out.println("Winner: " + fight4.getWinner().getClass().getSimpleName());
        System.out.println("Loser: " + fight4.getLoser().getClass().getSimpleName());
        System.out.println();

    }

    private static Arena getRandomArena() {
        List<Arena> arenas = new ArrayList<>();
        arenas.add(new Arena("Temple", 0.1, 0.1));
        arenas.add(new Arena("Castle", 0.2, 2.0));
        arenas.add(new Arena("Battlefield", 0.15, 1.5));
        arenas.add(new Arena("Woods", 0.3, 3.0));

        Random random = new Random();
        int index = random.nextInt(arenas.size());
        return arenas.get(index);
    }
}

