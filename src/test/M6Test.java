import com.example.game.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.util.HashMap;

public class M6Test {

    private StoreGame game;
    private LandscapeController landscapeController;
    private GameDetails gameDetails;
    private HashMap<Integer, Integer> pathDamage;

    @Before
    public void setup() throws IOException {
        game = new StoreGame();
        gameDetails = new GameDetails(1000, 2000, "MEDIUM", "JUnit Tests");
        game.setGameDetails(gameDetails);
        landscapeController = new LandscapeController();
        landscapeController.initializeM6Tests();
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of a single bad tower
     */
    @Test
    public void testPlaceAndUpgradeSingleTowerSuccessBad() {
        landscapeController.testPlaceTower(4,2, "bad");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 80 && pathDamage.get(37) == 80 &&
                        pathDamage.get(38) == 80 && pathDamage.get(39) == 80 &&
                        pathDamage.get(63) == 80 && pathDamage.size() == 5
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of a single normal tower
     */
    @Test
    public void testPlaceAndUpgradeSingleTowerSuccessNormal() {
        landscapeController.testPlaceTower(4,2, "normal");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 90 && pathDamage.get(37) == 90 &&
                        pathDamage.get(38) == 90 && pathDamage.get(39) == 90 &&
                        pathDamage.get(63) == 90 && pathDamage.size() == 5
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of a single elite tower
     */
    @Test
    public void testPlaceAndUpgradeSingleTowerSuccessElite() {
        landscapeController.testPlaceTower(4,2, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 110 && pathDamage.get(37) == 110 &&
                        pathDamage.get(38) == 110 && pathDamage.get(39) == 110 &&
                        pathDamage.get(63) == 110 && pathDamage.size() == 5
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of a single bad tower
     */
    @Test
    public void testPlaceAndUpgradeSingleTowerWithoutPurchasingUpgradeBad() {
        landscapeController.testPlaceTower(4,2, "bad");
        landscapeController.testUpgradeTower(4, 2);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 50 && pathDamage.get(37) == 50 &&
                        pathDamage.get(38) == 50 && pathDamage.get(39) == 50 &&
                        pathDamage.get(63) == 50 && pathDamage.size() == 5
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of a single normal tower
     */
    @Test
    public void testPlaceAndUpgradeSingleTowerWithoutPurchasingUpgradeNormal() {
        landscapeController.testPlaceTower(4,2, "normal");
        landscapeController.testUpgradeTower(4, 2);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 60 && pathDamage.get(37) == 60 &&
                        pathDamage.get(38) == 60 && pathDamage.get(39) == 60 &&
                        pathDamage.get(63) == 60 && pathDamage.size() == 5
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of a single elite tower
     */
    @Test
    public void testPlaceAndUpgradeSingleTowerWithoutPurchasingUpgradeElite() {
        landscapeController.testPlaceTower(4,2, "elite");
        landscapeController.testUpgradeTower(4, 2);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 80 && pathDamage.get(37) == 80 &&
                        pathDamage.get(38) == 80 && pathDamage.get(39) == 80 &&
                        pathDamage.get(63) == 80 && pathDamage.size() == 5
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of multiple bad towers
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersSuccessBad() {
        landscapeController.testPlaceTower(4,2, "bad");
        landscapeController.testPlaceTower(5, 4, "bad");
        landscapeController.testPlaceTower(7, 4, "bad");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 160 && pathDamage.get(37) == 80 &&
                        pathDamage.get(38) == 80 && pathDamage.get(39) == 80 &&
                        pathDamage.get(75) == 160 && pathDamage.get(76) == 160 &&
                        pathDamage.get(77) == 160 && pathDamage.get(63) == 160 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of multiple normal towers
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersSuccessNormal() {
        landscapeController.testPlaceTower(4,2, "normal");
        landscapeController.testPlaceTower(5, 4, "normal");
        landscapeController.testPlaceTower(7, 4, "normal");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 180 && pathDamage.get(37) == 90 &&
                        pathDamage.get(38) == 90 && pathDamage.get(39) == 90 &&
                        pathDamage.get(75) == 180 && pathDamage.get(76) == 180 &&
                        pathDamage.get(77) == 180 && pathDamage.get(63) == 180 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of multiple elite towers
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersSuccessElite() {
        landscapeController.testPlaceTower(4,2, "elite");
        landscapeController.testPlaceTower(5, 4, "elite");
        landscapeController.testPlaceTower(7, 4, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 220 && pathDamage.get(37) == 110 &&
                        pathDamage.get(38) == 110 && pathDamage.get(39) == 110 &&
                        pathDamage.get(75) == 220 && pathDamage.get(76) == 220 &&
                        pathDamage.get(77) == 220 && pathDamage.get(63) == 220 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of multiple mixed towers
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersSuccessMixed() {
        landscapeController.testPlaceTower(4,2, "bad");
        landscapeController.testPlaceTower(5, 4, "normal");
        landscapeController.testPlaceTower(7, 4, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 170 && pathDamage.get(37) == 80 &&
                        pathDamage.get(38) == 80 && pathDamage.get(39) == 80 &&
                        pathDamage.get(75) == 200 && pathDamage.get(76) == 200 &&
                        pathDamage.get(77) == 200 && pathDamage.get(63) == 170 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of multiple bad towers
     * Improper in this context means that only the first tower placed is actually upgraded, while the others are not
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersOnlyOneUpgradePurchasedBad() {
        landscapeController.testPlaceTower(4,2, "bad");
        landscapeController.testPlaceTower(5, 4, "bad");
        landscapeController.testPlaceTower(7, 4, "bad");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 130 && pathDamage.get(37) == 80 &&
                        pathDamage.get(38) == 80 && pathDamage.get(39) == 80 &&
                        pathDamage.get(75) == 100 && pathDamage.get(76) == 100 &&
                        pathDamage.get(77) == 100 && pathDamage.get(63) == 130 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of multiple normal towers
     * Improper in this context means that only the first tower placed is actually upgraded, while the others are not
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersOnlyOneUpgradePurchasedNormal() {
        landscapeController.testPlaceTower(4,2, "normal");
        landscapeController.testPlaceTower(5, 4, "normal");
        landscapeController.testPlaceTower(7, 4, "normal");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 150 && pathDamage.get(37) == 90 &&
                        pathDamage.get(38) == 90 && pathDamage.get(39) == 90 &&
                        pathDamage.get(75) == 120 && pathDamage.get(76) == 120 &&
                        pathDamage.get(77) == 120 && pathDamage.get(63) == 150 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of multiple elite towers
     * Improper in this context means that only the first tower placed is actually upgraded, while the others are not
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersOnlyOneUpgradePurchasedElite() {
        landscapeController.testPlaceTower(4,2, "elite");
        landscapeController.testPlaceTower(5, 4, "elite");
        landscapeController.testPlaceTower(7, 4, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 190 && pathDamage.get(37) == 110 &&
                        pathDamage.get(38) == 110 && pathDamage.get(39) == 110 &&
                        pathDamage.get(75) == 160 && pathDamage.get(76) == 160 &&
                        pathDamage.get(77) == 160 && pathDamage.get(63) == 190 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and improper upgrade of multiple mixed towers
     * Improper in this context means that only the first tower placed is actually upgraded, while the others are not
     */
    @Test
    public void testPlaceAndUpgradeMultipleTowersOnlyOneUpgradePurchasedMixed() {
        landscapeController.testPlaceTower(4,2, "bad");
        landscapeController.testPlaceTower(5, 4, "normal");
        landscapeController.testPlaceTower(7, 4, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(4, 2);
        landscapeController.testUpgradeTower(5, 4);
        landscapeController.testUpgradeTower(7, 4);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 140 && pathDamage.get(37) == 80 &&
                        pathDamage.get(38) == 80 && pathDamage.get(39) == 80 &&
                        pathDamage.get(75) == 140 && pathDamage.get(76) == 140 &&
                        pathDamage.get(77) == 140 && pathDamage.get(63) == 140 &&
                        pathDamage.size() == 8
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of a single bad tower
     * This test is distinct from earlier tests as the tower placed in this test is out-of-range
     *      of the path the enemies take on their way to attack the monument
     */
    @Test
    public void testPlaceSingleTowerOutOfRangeAndUpgradeTowerBad() {
        landscapeController.testPlaceTower(5,1, "bad");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 1);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.size() == 0
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of a single normal tower
     * This test is distinct from earlier tests as the tower placed in this test is out-of-range
     *      of the path the enemies take on their way to attack the monument
     */
    @Test
    public void testPlaceSingleTowerOutOfRangeAndUpgradeTowerNormal() {
        landscapeController.testPlaceTower(5,1, "normal");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 1);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.size() == 0
        );
    }

    /**
     * This test checks enemy damage with the placement and proper upgrade of a single elite tower
     * This test is distinct from earlier tests as the tower placed in this test is out-of-range
     *      of the path the enemies take on their way to attack the monument
     */
    @Test
    public void testPlaceSingleTowerOutOfRangeAndUpgradeTowerElite() {
        landscapeController.testPlaceTower(5,1, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 1);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.size() == 0
        );
    }

    /**
     * This test checks enemy damage with the placement of one bad tower which is in-range
     *      and one bad tower which is out-of-range, and with the upgrade only being
     *      applied to the out-of-range tower
     */
    @Test
    public void testPlaceOneTowerInRangeOneTowerOutOfRangeUpgradeWrongTowerBad() {
        landscapeController.testPlaceTower(5,1, "bad");
        landscapeController.testPlaceTower(5,2, "bad");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 1);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 50 && pathDamage.get(75) == 50 &&
                        pathDamage.get(63) == 50 && pathDamage.size() == 3
        );
    }

    /**
     * This test checks enemy damage with the placement of one normal tower which is in-range
     *      and one normal tower which is out-of-range, and with the upgrade only being
     *      applied to the out-of-range tower
     */
    @Test
    public void testPlaceOneTowerInRangeOneTowerOutOfRangeUpgradeWrongTowerNormal() {
        landscapeController.testPlaceTower(5,1, "normal");
        landscapeController.testPlaceTower(5,2, "normal");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 1);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 60 && pathDamage.get(75) == 60 &&
                        pathDamage.get(63) == 60 && pathDamage.size() == 3
        );
    }

    /**
     * This test checks enemy damage with the placement of one elite tower which is in-range
     *      and one elite tower which is out-of-range, and with the upgrade only being
     *      applied to the out-of-range tower
     */
    @Test
    public void testPlaceOneTowerInRangeOneTowerOutOfRangeUpgradeWrongTowerElite() {
        landscapeController.testPlaceTower(5,1, "elite");
        landscapeController.testPlaceTower(5,2, "elite");
        landscapeController.purchaseUpgrade();
        landscapeController.testUpgradeTower(5, 1);
        pathDamage = landscapeController.getTestingPathDamage();
        Assertions.assertTrue(
                pathDamage.get(51) == 80 && pathDamage.get(75) == 80 &&
                        pathDamage.get(63) == 80 && pathDamage.size() == 3
        );
    }

}