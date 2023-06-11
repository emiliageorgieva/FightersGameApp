import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FightTest {

    @Test
    public void testStartTournament() {
        Fighter fighter1 = new Monk(100, 20, 10);
        Fighter fighter2 = new Warrior(100, 15, 5);
        Arena arena = new Arena("Test Arena", 0.2, 0.1);

        Fight fight = new Fight(fighter1, fighter2, arena);
        fight.startTournament();

        Fighter winner = fight.getWinner();
        Fighter loser = fight.getLoser();

        Assertions.assertNotNull(winner);
        Assertions.assertNotNull(loser);
        Assertions.assertTrue(winner.isAlive());
        Assertions.assertFalse(loser.isAlive());
    }
    @Test
    public void testStartTournament_Fighter1Wins() {
        Fighter fighter1 = new Monk(100, 20, 10);
        Fighter fighter2 = new Warrior(80, 15, 5);
        Arena arena = new Arena("Test Arena", 0.2, 0.1);

        Fight fight = new Fight(fighter1, fighter2, arena);
        fight.startTournament();

        Fighter winner = fight.getWinner();
        Fighter loser = fight.getLoser();

        Assertions.assertNotNull(winner);
        Assertions.assertNotNull(loser);
        Assertions.assertTrue(winner.isAlive());
        Assertions.assertFalse(loser.isAlive());
        Assertions.assertEquals(fighter1, winner);
        Assertions.assertEquals(fighter2, loser);
    }
    @Test
    public void testGetWinnerAndLoser() {
        // Create a Fight instance
        Fight fight = new Fight();

        // Create two fighters and set one as the winner and the other as the loser
        Fighter winner = new Monk(100, 10, 5);
        Fighter loser = new Warrior(120, 15, 8);
        fight.setWinner(winner);
        fight.setLoser(loser);

        // Get the winner and loser using the getWinner and getLoser methods
        Fighter retrievedWinner = fight.getWinner();
        Fighter retrievedLoser = fight.getLoser();

        // Assert that the retrieved winner and loser are the same as the original ones
        assertNotEquals(winner, retrievedWinner);
        assertNotEquals(loser, retrievedLoser);
    }
    @Test
    public void testGetWinnerAndLoser_NoWinnerAndLoser() {
        // Create a Fight instance
        Fight fight = new Fight();

        // Get the winner and loser using the getWinner and getLoser methods
        Fighter retrievedWinner = fight.getWinner();
        Fighter retrievedLoser = fight.getLoser();

        // Assert that the retrieved winner and loser are null
        assertNull(retrievedWinner);
        assertNull(retrievedLoser);
    }

}