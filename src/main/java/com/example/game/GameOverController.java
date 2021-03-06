package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class GameOverController {
    @FXML
    private Label gameOverText;
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


        this.enemiesKilledText.setText("Enemies Killed: " + gameDetails.getDeadEnemies());
        this.gameOverText.setText("Game Over!");
        this.moneyText.setText("Money Left: " + gameDetails.getMoney());
        this.damageDoneText.setText("Monument health left: " + gameDetails.getHealth());
        this.developersText.setText("Developed by: Big-O-micron");
    }
}