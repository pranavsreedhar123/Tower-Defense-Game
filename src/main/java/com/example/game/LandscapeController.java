package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class LandscapeController {
    @FXML
    private Label moneyText;
    @FXML
    private VBox data;
    @FXML
    private ImageView background;
    @FXML
    private Button quit;


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
                    URL url = TowerDefenseApplication.class.getResource("assets/images/Easy.jpg");
                    backgroundImage = new Image(String.valueOf(url));
                } else if (level.equals("MEDIUM")) {
                    URL url = TowerDefenseApplication.class.getResource("assets/images/Medium.png");
                    backgroundImage = new Image(String.valueOf(url));
                } else if (level.equals("HARD")) {
                    URL url = TowerDefenseApplication.class.getResource("assets/images/Hard.png");
                    backgroundImage = new Image(String.valueOf(url));
                }
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Check image");
                alert.show();
            }
            background.setImage(backgroundImage);
            background.setFitWidth(820);
            background.setFitHeight(500);
            background.setPreserveRatio(true);

//            Image buttonImg = new Image("../../main/resources/com/example/game/assets/images/Quit.png");
//            ImageView quitImg = new ImageView(buttonImg);
//            quitImg.setFitHeight(80);
//            quitImg.setPreserveRatio(true);
//            quit.setGraphic(quitImg);
        }
    }
//    protected void onHomePage(ActionEvent e) throws IOException {
//        FXMLLoader homePaneLoader = new FXMLLoader(
//                TowerDefenseApplication.class.getResource("configuration.fxml"));
//        Parent homeScreen = homePaneLoader.load();
//        Scene homeScene = new Scene(homeScreen, 800, 480);
//        homeScene.getRoot().setStyle("-fx-font-family: 'Arial'");
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        stage.setTitle("Homepage");
//        stage.setScene(homeScene);
//    }

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
