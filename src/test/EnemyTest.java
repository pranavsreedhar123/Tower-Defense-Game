import com.example.game.TowerDefenseApplication;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import org.testfx.matcher.base.NodeMatchers;

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
        clickOn("#easy");
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
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#start");
        verifyThat("#shop", NodeMatchers.isDisabled());
    }
}