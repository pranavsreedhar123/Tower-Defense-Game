import com.example.game.TowerDefenseApplication;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class LandscapeTest extends ApplicationTest {
    /**
     * Starts up TowerDefenseApplication.
     * @param stage Stage
     * @throws Exception exception
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

    /**
     * Tests if the level is medium, then the money is 250 dollars
     */
    @Test
    public void testMediumMoney() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#medium");
        clickOn("#begin");
        clickOn("OK");
        verifyThat("#moneyText", LabeledMatchers.hasText("$250"));
    }

    /**
     * Tests if the level is medium, then the health is 2000
     */
    @Test
    public void testMediumHealth() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#medium");
        clickOn("#begin");
        clickOn("OK");
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 2000"));
    }
    /**
     * Tests if the level is hard, then the money is 100 dollars
     */
    @Test
    public void testHardMoney() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        verifyThat("#moneyText", LabeledMatchers.hasText("$100"));
    }

    /**
     * Tests if the level is hard, then the health is 1000
     */
    @Test
    public void testHardHealth() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#hard");
        clickOn("#begin");
        clickOn("OK");
        verifyThat("#dynamicHealthText", LabeledMatchers.hasText(" 1000"));
    }

    /**
     * Checks if multiple towers can be added when one is purchased
     */
    @Test
    public void testCheckPurchase() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#shop");
        clickOn("Buy $100!");
        clickOn("#1,4");
        verifyThat("#1,4", NodeMatchers.isNotNull());
    }
}