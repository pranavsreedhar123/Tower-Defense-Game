import com.example.game.TowerDefenseApplication;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class EnemyTest extends ApplicationTest {
    /**
     * Starts up TowerDefenseApplication.
     *
     * @param stage Stage
     * @throws Exception exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        TowerDefenseApplication towerDefenseApplication = new TowerDefenseApplication();
        towerDefenseApplication.start(stage);
    }

    /**
     * Tests if the start button is disabled on click of start
     */
    @Test
    public void testCombatStartButton() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        verifyThat("#start", NodeMatchers.isDisabled());
    }

    /**
     * Tests if the shop button is disabled on click of start
     */
    @Test
    public void testCombatShopButton() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        verifyThat("#shop", NodeMatchers.isDisabled());
    }

    /**
     * Tests if the enemy movement does not impact the monument before it reaches the monument.
     */
    @Test
    public void testMonumentUnaffected() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(2000);
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 1000"));

    }

    /**
     * Tests if the enemy reaches the monument in the expected time.
     */
    @Test
    public void testEnemyReaches() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(10000);
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 900"));

    }

    /**
     * Tests if the enemy appropriately reduces the monument health to 0.
     */
    @Test
    public void testEnemyReachesAndDegrades() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(10000);

        for (int i = 1; i <= 10; i++) {
            verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" " + (10 - i) * 1000));
            Thread.sleep(500);
        }
    }

    /**
     * Tests the Game Over screen.
     */
    @Test
    public void testGameOver() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(15000);
        verifyThat("#gameOverText", LabeledMatchers.hasText("Game Over!"));
    }
    /**
     * Tests the play again functionality after the user loses a game.
     */
    @Test
    public void testPlayAgain() throws InterruptedException {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(15000);
        clickOn("#play");
        verifyThat("#initText", LabeledMatchers.hasText("Welcome to the Tower Defense Game!"));
    }
}