package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;


public class LandscapeController {
    @FXML
    private Label moneyText;
    @FXML
    private VBox data;
    @FXML
    private ImageView background;


    private Integer EASY_MONEY = 500;
    private Integer MEDIUM_MONEY = 250;
    private Integer HARD_MONEY = 100;
    private GameDetails gameDetails;
    private Image backgroundImage;



    @FXML
    private void initialize() {
        gameDetails = StoreGame.getGameDetails();
        String level = StoreGame.getGameDetails().getLevel();
        if (gameDetails != null) {
            data.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            this.moneyText.setText("MONEY: " + gameDetails.getMoney());
            this.moneyText.toFront();
            try {
                if (level.equals("EASY")) {
                   // URL url = TowerDefenseApplication.class.getResource("../../main/resources/com/example/game/assets/images/Easy.jpg");
                    //backgroundImage = new Image(String.valueOf(url));
                    backgroundImage = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Georgia_Tech_Yellow_Jackets_logo.svg/1200px-Georgia_Tech_Yellow_Jackets_logo.svg.png");
                } else if (level.equals("MEDIUM")) {
                    // URL url = TowerDefenseApplication.class.getResource("../../main/resources/com/example/game/assets/images/Medium.png");
                    //backgroundImage = new Image(String.valueOf(url));
                    backgroundImage = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Georgia_Tech_Yellow_Jackets_logo.svg/1200px-Georgia_Tech_Yellow_Jackets_logo.svg.png");
                } else if (level.equals("HARD")) {
                    // URL url = TowerDefenseApplication.class.getResource("../../main/resources/com/example/game/assets/images/Hard.png");
                    //backgroundImage = new Image(String.valueOf(url));
                    backgroundImage = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Georgia_Tech_Yellow_Jackets_logo.svg/1200px-Georgia_Tech_Yellow_Jackets_logo.svg.png");
                }
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Check image");
                alert.show();
            }
            background.setImage(backgroundImage);

            background.setFitWidth(1000);
            background.setFitHeight(1000);
            background.setPreserveRatio(true);
        }
    }

//    public void setMoney(String difficulty) {
//        this.moneyText.setTextFill(Color.GREEN);
//
//        if (difficulty.equals("EASY")) {
//            this.moneyText.setText("MONEY: " + this.EASY_MONEY.toString());
//
//        } else if (difficulty.equals("MEDIUM")) {
//            this.moneyText.setText("MONEY: " + this.MEDIUM_MONEY.toString());
//        } else if (difficulty.equals("HARD")) {
//            this.moneyText.setText("MONEY: " + this.HARD_MONEY.toString());
//        }
//    }
}
