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
    private Image badImg;
    private Image normalImg;
    private Image eliteImg;

    private LandscapeController lsc = new LandscapeController();
    @FXML
    private Label eliteText;
    @FXML
    private Label normalText;
    @FXML
    private Label badText;
    @FXML
    private ImageView badImage;
    @FXML
    private ImageView normalImage;
    @FXML
    private ImageView eliteImage;
    @FXML
    private Button bad;
    @FXML
    private Button normal;
    @FXML
    private Button elite;

    private GameDetails gameDetails;
    private int currentMoney;
    private int elitecost = 500;
    private int normalcost = 250;
    private int badcost = 100;

    @FXML
    private Label shopMoney;

    @FXML
    private void initialize() {

        this.shopText.setText("Welcome to the Shop!");
        gameDetails = StoreGame.getGameDetails();
        this.currentMoney = gameDetails.getMoney();
        this.shopMoney.setText("MONEY: $" + this.currentMoney);

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

        try {
            URL url = TowerDefenseApplication.class.getResource("assets/images/BadTower.png");
            badImg = new Image(String.valueOf(url));
        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error in accessing assets");
            alert.show();
        }
        badImage.setImage(badImg);
        badImage.setFitHeight(200);
        badImage.setFitWidth(200);
        badImage.setPreserveRatio(true);

        try {
            URL url = TowerDefenseApplication.class.getResource("assets/images/NormalTower.png");
            normalImg = new Image(String.valueOf(url));
        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error in accessing assets");
            alert.show();
        }
        normalImage.setImage(normalImg);
        normalImage.setFitHeight(200);
        normalImage.setFitWidth(2090);
        normalImage.setPreserveRatio(true);

        try {
            URL url = TowerDefenseApplication.class.getResource("assets/images/EliteTower.png");
            eliteImg = new Image(String.valueOf(url));
        } catch (IllegalArgumentException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error in accessing assets");
            alert.show();
        }
        eliteImage.setImage(eliteImg);
        eliteImage.setFitHeight(200);
        eliteImage.setFitWidth(200);
        eliteImage.setPreserveRatio(true);

        if (gameDetails.getLevel().equals("MEDIUM")) {
            elitecost *= 2;
            normalcost *= 2;
            badcost *= 2;
        } else if (gameDetails.getLevel().equals("HARD")) {
            elitecost *= 3;
            normalcost *= 3;
            badcost *= 3;
        }
        bad.setText("$" + badcost + " (" + LandscapeController.BADTOWERDAMAGE + " damage)");
        normal.setText("$" + normalcost + " (" + LandscapeController.BADTOWERDAMAGE + " damage)");
        elite.setText("$" + elitecost + " (" + LandscapeController.BADTOWERDAMAGE + " damage)");
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

        if (this.currentMoney < elitecost) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Funds!");
            alert.showAndWait();
        } else {
            this.currentMoney -= elitecost;
            this.gameDetails.setMoney(this.currentMoney);
            this.onGameScreen(e);
            gameDetails.setImage("elite");
        }
    }

    @FXML
    protected void purchaseNormal(ActionEvent e) throws java.io.IOException {

        if (this.currentMoney < normalcost) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Funds!");
            alert.showAndWait();
        } else {
            this.currentMoney -= normalcost;
            this.gameDetails.setMoney(this.currentMoney);
            this.onGameScreen(e);
            gameDetails.setImage("normal");
        }
    }

    @FXML
    protected void purchaseBad(ActionEvent e) throws java.io.IOException {


        if (this.currentMoney < badcost) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Funds!");
            alert.showAndWait();
        } else {
            this.currentMoney -= badcost;
            this.gameDetails.setMoney(this.currentMoney);
            this.onGameScreen(e);
            StoreGame.getGameDetails().setImage("bad");
        }
    }
}
