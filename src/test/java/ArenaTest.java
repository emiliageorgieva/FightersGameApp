import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {
    @Test
    public void testGetDodgeAdvantage() {
        Arena arena = new Arena("Temple", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.1;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }

    @Test
    public void testGetDamageAdvantage() {
        Arena arena = new Arena("Battlefield", 0.1, 0.5);
        double expectedDamageAdvantage = 0.5;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }

    @Test
    public void testGetDodgeChance() {
        Arena arena = new Arena("Temple", 0.1, 0.2);
        double expectedDodgeChance = 0.1;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance,actualDodgeChance, 0.0001); //use delta for double comparison
    }

    @Test
    public void testGetDodgeAdvantageTempleLocationReturnsExpectedValue() {
        Arena arena = new Arena("Temple", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.1;
        double actualDodgAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage,actualDodgAdvantage, 0.0001);
    }
    @Test
    public void testGetDodgeAdvantageCastleLocationReturnsExpectedValue() {
        Arena arena = new Arena("Castle", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.0;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }

    @Test
    public void testGetDodgeAdvantageBattlefieldLocationReturnsExpectedValue() {
        Arena arena = new Arena("Battlefield", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.0;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }

    @Test
    public void testGetDodgeAdvantageWoodsLocationReturnsExpectedValue() {
        Arena arena = new Arena("Woods", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.2;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }

    @Test
    public void testGetDodgeAdvantageUnknownLocationReturnsDefaultAdvantage() {
        Arena arena = new Arena("Unknown", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.0;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }

    @Test
    public void testGetDamageAdvantageTempleLocationReturnsExpectedValue() {
        Arena arena = new Arena("Temple", 0.1, 0.2);
        double expectedDamageAdvantage = 0.0;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }

    @Test
    public void testGetDamageAdvantageCastleLocationReturnsExpectedValue() {
        Arena arena = new Arena("Castle", 0.1, 0.2);
        double expectedDamageAdvantage = 0.0;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }

    @Test
    public void testGetDamageAdvantageBattlefieldLocationReturnsExpectedValue() {
        Arena arena = new Arena("Battlefield", 0.1, 0.2);
        double expectedDamageAdvantage = 0.5;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }
    @Test
    public void testGetDamageAdvantageWoodsLocationReturnsExpectedValue() {
        Arena arena = new Arena("Woods", 0.1, 0.2);
        double expectedDamageAdvantage = 0.0;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }

    @Test
    public void testGetDamageAdvantageUnknownLocationReturnsDefaultAdvantage() {
        Arena arena = new Arena("Unknown", 0.1, 0.2);
        double expectedDamageAdvantage = 0.0;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }

    @Test
    public void testGetDodgeChanceTempleLocationReturnsExpectedValue() {
        Arena arena = new Arena("Temple", 0.1, 0.2);
        double expectedDodgeChance = 0.1;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance, actualDodgeChance, 0.0001);
    }

    @Test
    public void testGetDodgeChanceCastleLocationReturnsExpectedValue() {
        Arena arena = new Arena("Castle", 0.1, 0.2);
        double expectedDodgeChance = 0.0;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance, actualDodgeChance, 0.0001);
    }

    @Test
    public void testGetDodgeChanceBattlefieldLocationReturnsExpectedValue() {
        Arena arena = new Arena("Battlefield", 0.1, 0.2);
        double expectedDodgeChance = 0.0;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance, actualDodgeChance, 0.0001);
    }

    @Test
    public void testGetDodgeChanceWoodsLocationReturnsExpectedValue() {
        Arena arena = new Arena("Woods", 0.1, 0.2);
        double expectedDodgeChance = 0.0;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance, actualDodgeChance, 0.0001);
    }

    @Test
    public void testGetDodgeChanceUnknownLocationReturnsDefaultChance() {
        Arena arena = new Arena("Unknown", 0.1, 0.2);
        double expectedDodgeChance = 0.0;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance, actualDodgeChance, 0.0001);
    }

    @Test
    public void testGetDodgeAdvantageSpecialCharactersInNameReturnsDefaultAdvantage() {
        Arena arena = new Arena("!!@#$%", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.0;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }
    @Test
    public void testGetDamageAdvantage_NegativeValues_ReturnsZeroAdvantage() {
        Arena arena = new Arena("Castle", -0.1, -0.2);
        double expectedDamageAdvantage = 0.0;
        double actualDamageAdvantage = arena.getDamageAdvantage();
        assertEquals(expectedDamageAdvantage, actualDamageAdvantage, 0.0001);
    }

    @Test
    public void testGetDodgeAdvantageEmptyNameReturnsDefaultAdvantage() {
        Arena arena = new Arena("", 0.1, 0.2);
        double expectedDodgeAdvantage = 0.0;
        double actualDodgeAdvantage = arena.getDodgeAdvantage();
        assertEquals(expectedDodgeAdvantage, actualDodgeAdvantage, 0.0001);
    }
    @Test
    public void testGetDodgeAdvantagePerformanceTest() {
        Arena arena = new Arena("Temple", 0.1, 0.2);

        // Measure the execution time of getDodgeAdvantage method
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            arena.getDodgeAdvantage();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        assertTrue(executionTime < 1000); // Ensure the execution time is within an acceptable range
    }

    @Test
    public void testGetNameReturnsExpectedName() {
        String expectedName = "Temple";
        Arena arena = new Arena(expectedName, 0.1, 0.2);
        String actualName = arena.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    public void testGetNameNullNameReturnsNull() {
        Arena arena = new Arena(null, 0.1, 0.2);
        assertNull(arena.getName());
    }

    @Test
    public void testGetDodgeChanceRoundChanceValueReturnsExpectedValue() {
        Arena arena = new Arena("Temple", 0.1, 0.25);
        double expectedDodgeChance = 0.1;
        double actualDodgeChance = arena.getDodgeChance();
        assertEquals(expectedDodgeChance, actualDodgeChance, 0.0001);
    }
}

