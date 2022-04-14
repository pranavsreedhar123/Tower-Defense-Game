import com.example.game.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.util.HashMap;

public class M5Test {

    private StoreGame game;
    private LandscapeController landscapeController;
    private GameDetails gameDetails;
    private WelcomeController welcomeController;

    @Before
    public void setup() throws IOException {
        game = new StoreGame();
        gameDetails = new GameDetails(1000, 2000, "MEDIUM", "JUnit Tests");
        game.setGameDetails(gameDetails);
        landscapeController = new LandscapeController();
        landscapeController.initializeJUnits();
    }

    /**
     * This test checks enemy damage with the placement of a single bad tower
     */
    @Test
    public void testPlacementOfSingleTowerBad() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(2, 0, "bad");
        Assertions.assertTrue(
                pathDamage.get(12) == 40 && pathDamage.get(13) == 40
                        && pathDamage.get(25) == 40 && pathDamage.get(37) == 40
                        && pathDamage.size() == 4
        );
    }

    /**
     * This test checks enemy damage with the placement of a single normal tower
     */
    @Test
    public void testPlacementOfSingleTowerNormal() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(2, 0, "normal");
        Assertions.assertTrue(
                pathDamage.get(12) == 60 && pathDamage.get(13) == 60
                        && pathDamage.get(25) == 60 && pathDamage.get(37) == 60
                        && pathDamage.size() == 4
        );
    }

    /**
     * This test checks enemy damage with the placement of a single elite tower
     */
    @Test
    public void testPlacementOfSingleTowerElite() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(2, 0, "elite");
        Assertions.assertTrue(
                pathDamage.get(12) == 80 && pathDamage.get(13) == 80
                         && pathDamage.get(25) == 80 && pathDamage.get(37) == 80
                         && pathDamage.size() == 4
        );
    }

    /**
     * This test checks enemy damage with the placement of a multiple bad towers
     */
    @Test
    public void testPlacementOfMultipleTowersBad() {
        landscapeController.testPlaceTower(2, 0, "bad");
        landscapeController.testPlaceTower(2, 2, "bad");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(4, 2, "bad");
        Assertions.assertTrue(
            pathDamage.get(51) == 40 && pathDamage.get(37) == 120
            && pathDamage.get(38) == 80 && pathDamage.get(39) == 80
            && pathDamage.get(25) == 80 && pathDamage.get(12) == 40
            && pathDamage.get(13) == 80 && pathDamage.get(63) == 40
            && pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement of a multiple normal towers
     */
    @Test
    public void testPlacementOfMultipleTowersNormal() {
        landscapeController.testPlaceTower(2, 0, "normal");
        landscapeController.testPlaceTower(2, 2, "normal");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(4, 2, "normal");
        Assertions.assertTrue(
                pathDamage.get(51) == 60 && pathDamage.get(37) == 180
                        && pathDamage.get(38) == 120 && pathDamage.get(39) == 120
                        && pathDamage.get(25) == 120 && pathDamage.get(12) == 60
                        && pathDamage.get(13) == 120 && pathDamage.get(63) == 60
                        && pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement of a multiple elite towers
     */
    @Test
    public void testPlacementOfMultipleTowersElite() {
        landscapeController.testPlaceTower(2, 0, "elite");
        landscapeController.testPlaceTower(2, 2, "elite");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(4, 2, "elite");
        Assertions.assertTrue(
                pathDamage.get(51) == 80 && pathDamage.get(37) == 240
                        && pathDamage.get(38) == 160 && pathDamage.get(39) == 160
                        && pathDamage.get(25) == 160 && pathDamage.get(12) == 80
                        && pathDamage.get(13) == 160 && pathDamage.get(63) == 80
                        && pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement of a multiple mixed towers
     */
    @Test
    public void testPlacementOfMultipleTowersMixed() {
        landscapeController.testPlaceTower(2, 0, "bad");
        landscapeController.testPlaceTower(2, 2, "normal");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(4, 2, "elite");
        Assertions.assertTrue(
                pathDamage.get(51) == 80 && pathDamage.get(37) == 180
                        && pathDamage.get(38) == 140 && pathDamage.get(39) == 140
                        && pathDamage.get(25) == 100 && pathDamage.get(12) == 40
                        && pathDamage.get(13) == 100 && pathDamage.get(63) == 80
                        && pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement of a single bad tower which is out of range
     */
    @Test
    public void testPlacementOfSingleTowerOutOfRangeBad() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(0, 7, "bad");
        Assertions.assertTrue(
                        pathDamage.size() == 0
        );
    }

    /**
     * This test checks enemy damage with the placement of a single normal tower
     * which is out of range
     */
    @Test
    public void testPlacementOfSingleTowerOutOfRangeNormal() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(0, 7, "normal");
        Assertions.assertTrue(
                pathDamage.size() == 0
        );
    }

    /**
     * This test checks enemy damage with the placement of a single elite tower
     * which is out of range
     */
    @Test
    public void testPlacementOfSingleTowerOutOfRangeElite() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(0, 7, "elite");
        Assertions.assertTrue(
                pathDamage.size() == 0
        );
    }

    /**
     * This test checks enemy damage with the placement of multiple towers,
     * one of which is out of range and bad, and one of which is in range and bad
     */
    @Test
    public void testPlacementOfMultipleTowersOneOutOfRangeOneInRangeBad() {
        landscapeController.testPlaceTower(0, 7, "bad");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(7, 6, "bad");
        Assertions.assertTrue(
            pathDamage.get(77) == 40 && pathDamage.get(78) == 40
                    && pathDamage.get(79) == 40 && pathDamage.size() == 3
        );
    }

    /**
     * This test checks enemy damage with the placement of multiple towers,
     * one of which is out of range and normal, and one of which is in range and normal
     */
    @Test
    public void testPlacementOfMultipleTowersOneOutOfRangeOneInRangeNormal() {
        landscapeController.testPlaceTower(0, 7, "normal");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(7, 6, "normal");
        Assertions.assertTrue(
                pathDamage.get(77) == 60 && pathDamage.get(78) == 60
                        && pathDamage.get(79) == 60 && pathDamage.size() == 3
        );
    }

    /**
     * This test checks enemy damage with the placement of multiple towers,
     * one of which is out of range and elite, and one of which is in range and elite
     */
    @Test
    public void testPlacementOfMultipleTowersOneOutOfRangeOneInRangeElite() {
        landscapeController.testPlaceTower(0, 7, "elite");
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(7, 6, "elite");
        Assertions.assertTrue(
                pathDamage.get(77) == 80 && pathDamage.get(78) == 80
                        && pathDamage.get(79) == 80 && pathDamage.size() == 3
        );
    }

    /**
     * This test checks enemy damage with the invalid placement of a tower
     * (i.e) enemies should not be damage as no tower is placed on the map
     */
    @Test
    public void testPlacementOfZeroTowers() {
        HashMap<Integer, Integer> pathDamage = landscapeController.testPlaceTower(-1, -1, "bad");
        Assertions.assertTrue(
                pathDamage.size() == 0
        );
    }

}