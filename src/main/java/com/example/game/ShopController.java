package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;

public class ShopController {
    @FXML
    private Label shopText;
    @FXML
    private Button quit;
    private Image quitImg;

    @FXML
    private Label eliteText;
    @FXML
    private Label normalText;
    @FXML
    private Label badText;

    private GameDetails gameDetails;
    private int currentMoney;
    private int ELITE_COST = 750;
    private int NORMAL_COST = 500;
    private int BAD_COST = 250;

    @FXML
    private Label shopMoney;

    @FXML
    private void initialize() {
        this.shopText.setText("Welcome to the Shop!");
        gameDetails = StoreGame.getGameDetails();
        this.currentMoney = gameDetails.getMoney();
        this.shopMoney.setText("MONEY: " + this.currentMoney);

        try {
            URL url = TowerDefenseApplication.class.getResource("assets/images/Quit.png");
            quitImg = new Image(String.valueOf(url));
        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error in accessing assets");
            alert.show();
        }
        ImageView quitImgView = new ImageView();
        quitImgView.setImage(quitImg);
        quitImgView.setFitHeight(30);
        quitImgView.setFitWidth(30);
        quitImgView.setPreserveRatio(true);
        quit.setGraphic(quitImgView);
    }

    @FXML
    protected void onGameScreen(ActionEvent e) throws java.io.IOException {
        FXMLLoader configPaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("game.fxml"));
        Parent configScreen = configPaneLoader.load();
        Scene configScene = new Scene(configScreen, 1200, 900);
        configScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Game");
        stage.setScene(configScene);
    }

    @FXML
    protected void purchaseElite(ActionEvent e) throws java.io.IOException {
        if (this.currentMoney < this.ELITE_COST) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Funds!");
            alert.showAndWait();
        } else {
            this.currentMoney -= this.ELITE_COST;
            this.gameDetails.setMoney(this.currentMoney);
            this.onGameScreen(e);
        }
    }

    @FXML
    protected void purchaseNormal(ActionEvent e) throws java.io.IOException {
        if (this.currentMoney < this.NORMAL_COST) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Funds!");
            alert.showAndWait();
        } else {
            this.currentMoney -= this.NORMAL_COST;
            this.gameDetails.setMoney(this.currentMoney);
            this.onGameScreen(e);
        }
    }

    @FXML
    protected void purchaseBad(ActionEvent e) throws java.io.IOException {
        if (this.currentMoney < this.BAD_COST) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Funds!");
            alert.showAndWait();
        } else {
            this.currentMoney -= this.BAD_COST;
            this.gameDetails.setMoney(this.currentMoney);
            this.onGameScreen(e);
        }
    }
}
