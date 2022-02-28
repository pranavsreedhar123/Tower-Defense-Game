import com.example.game.TowerDefenseApplication;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import com.example.game.LandscapeController;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class LandscapeTest extends ApplicationTest {
    /**
     * Starts up TowerDefenseApplication.
     * @param stage Stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        TowerDefenseApplication towerDefenseApplication = new TowerDefenseApplication();
        towerDefenseApplication.start(stage);
    }
    /**
     * Tests if the level is easy, then the money is 500 dollars
     */
    @Test
    public void testEasyMoney() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        verifyThat("#moneyText", LabeledMatchers.hasText("$500"));
    }

    /**
     * Tests if the level is easy, then the health is 3000
     */
    @Test
    public void testEasyHealth() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 3000"));
    }
}