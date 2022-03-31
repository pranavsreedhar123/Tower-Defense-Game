import com.example.game.TowerDefenseApplication;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

/**
 * See "M4 Test Write-up.pdf" for further details
 */
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
     * Traverses to the initial config screen before assigning difficulty for testing.
     */
    @Before
    public void traverseToInitialConfigScreen() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
    }

    /**
     * Tests if the start button is disabled on click of start
     */
    @Test
    public void testCombatStartButton() throws InterruptedException {
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        verifyThat("#start", NodeMatchers.isDisabled());
    }

    /**
     * Tests if the shop button is disabled when start is clicked
     */
    @Test
    public void testCombatShopButton() throws InterruptedException {

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

        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(2000);
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 1000"));

    }

    /**
     * Tests if the enemy reaches the monument in the expected time in Easy Mode.
     */
    @Test
    public void testEnemyReachesEasy() throws InterruptedException {

        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(29500);
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 2900"));

    }

    /**
     * Tests if the enemy reaches the monument in the expected time in Medium Mode.
     */
    @Test
    public void testEnemyReachesMedium() throws InterruptedException {

        clickOn("#medium");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(19500);
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 1900"));

    }

    /**
     * Tests if the enemy reaches the monument in the expected time in Hard Mode.
     */
    @Test
    public void testEnemyReachesHard() throws InterruptedException {

        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(10000);
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 900"));

    }

    /**
     * Tests the Game Over screen - EASY MODE.
     */
    @Test
    public void testEasyGameOver() throws InterruptedException {

        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(75000);
        verifyThat("#gameOverText", LabeledMatchers.hasText("Game Over!"));
    }

    /**
     * Tests the Game Over screen - MEDIUM MODE.
     */
    @Test
    public void testMediumGameOver() throws InterruptedException {

        clickOn("#medium");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(40000);
        verifyThat("#gameOverText", LabeledMatchers.hasText("Game Over!"));
    }

    /**
     * Tests the Game Over screen - HARD MODE.
     */
    @Test
    public void testHardGameOver() throws InterruptedException {

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

        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        Thread.sleep(15000);
        clickOn("#play");
        verifyThat("#initText", LabeledMatchers.hasText("Welcome to the Tower Defense Game!"));
    }
}