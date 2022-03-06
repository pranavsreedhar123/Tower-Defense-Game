import com.example.game.TowerDefenseApplication;
import javafx.stage.Stage;
import javafx.scene.Node;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import org.testfx.matcher.control.LabeledMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class ShopTest extends ApplicationTest {
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
     * Tests if the money text is reduced by 100 if a bad tower is purchased
     */
    @Test
    public void testBadTowerPriceUpdate() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#shop");
        clickOn("Buy $100!");
        verifyThat("#moneyText", LabeledMatchers.hasText("$400"));
    }

    /**
     * Tests if the money text is reduced by 250 if a normal tower is purchased
     */
    @Test
    public void testNormalTowerPriceUpdate() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#shop");
        clickOn("Buy $250!");
        verifyThat("#moneyText", LabeledMatchers.hasText("$250"));
    }

    /**
     * Tests if the money text is reduced by 500 if an elite tower is purchased
     */
    @Test
    public void testEliteTowerPriceUpdate() {
        clickOn("#play");
        Node input = lookup("#nameText").query();
        clickOn(input);
        write("Test");
        clickOn("#easy");
        clickOn("#begin");
        clickOn("OK");
        clickOn("#shop");
        clickOn("Buy $500!");
        verifyThat("#moneyText", LabeledMatchers.hasText("$0"));
    }
}




