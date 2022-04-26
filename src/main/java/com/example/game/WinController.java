package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class WinController {
    @FXML
    private Label winText;
    @FXML
    private Label developersText;
    @FXML
    private Label enemiesKilledText;
    @FXML
    private Label damageDoneText;
    @FXML
    private Label moneyText;

    private GameDetails gameDetails;


    @FXML
    protected void onPlayButtonClick(ActionEvent e) throws java.io.IOException {
        FXMLLoader configPaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("configuration.fxml"));
        Parent configScreen = configPaneLoader.load();
        Scene configScene = new Scene(configScreen, 1200, 900);
        configScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Configuration");
        stage.setScene(configScene);
    }

    @FXML
    protected void onQuitButtonClick() {
        javafx.application.Platform.exit();
        System.exit(0);
    }

    @FXML
    public void initialize() {
        gameDetails = StoreGame.getGameDetails();
        String level = StoreGame.getGameDetails().getLevel();

        if (level.equals("EASY")) {
            this.enemiesKilledText.setText("Enemies killed: 5");
        } else if (level.equals("MEDIUM")) {
            this.enemiesKilledText.setText("Enemies killed: 10");
        } else {
            this.enemiesKilledText.setText("Enemies killed: 15");
        }
        this.winText.setText("YOU WIN!");
        this.damageDoneText.setText("Monument health left: " + gameDetails.getHealth());
        gameDetails.setMoney(gameDetails.getMoney() + gameDetails.getDeadEnemies()*50);
        this.moneyText.setText("Money Left: " + gameDetails.getMoney());
        this.developersText.setText("Developed by: Big-O-micron");
    }
}