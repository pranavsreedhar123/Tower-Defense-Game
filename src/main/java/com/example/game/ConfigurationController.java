package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;


public class ConfigurationController {
    @FXML
    private Label initText;
    @FXML
    private Label nameText;
    @FXML
    private Label levelText;
    @FXML
    private TextField name;
    @FXML
    private Button easy;
    @FXML
    private Button medium;
    @FXML
    private Button hard;
    @FXML
    private String level = "";
    @FXML
    private Button begin;

    private GameDetails gameDetails;
    private int money;
    private int health;

    @FXML
    private void initialize() {
        initText.setText("Welcome to the Tower Defense Game!");
        nameText.setText("Enter name: ");
        levelText.setText("Choose level: ");
        name.setPromptText("George P Burdell");
        easy.setText("Easy");
        medium.setText("Medium");
        hard.setText("Hard");
        begin.setText("Begin");

    }
    @FXML
    protected void onEasy(ActionEvent e) {
        level = "EASY";
        money = 2000;
        health = 3000;
    }
    @FXML
    protected void onMedium(ActionEvent e) {
        level = "MEDIUM";
        money = 1000;
        health = 2000;
    }
    @FXML
    protected void onHard(ActionEvent e) {
        level = "HARD";
        money = 800;
        health = 1000;
    }
    @FXML
    protected void onBegin(ActionEvent e) throws IOException {


        if (name.getText().isBlank() || name.getText().isEmpty()) {
            //System.out.println("hi");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please write a valid name");
            level = "";
            //alert.getDialogPane().setExpandableContent(new Label("Please write a valid name"));
            alert.showAndWait();
        } else if (level.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please choose a valid level");
            //alert.getDialogPane().setExpandableContent(new Label("Please choose a valid level"));
            alert.showAndWait();
        } else {
            Alert alert = new Alert(
                    Alert.AlertType.INFORMATION,
                    "Name: " + name.getText() + "\nLevel: " + level
            );
            alert.showAndWait();
            GameDetails old = StoreGame.getGameDetails();
            if (old != null) {
                gameDetails = new GameDetails(this.money + old.getExtraMoney(),
                        this.health, this.level, this.name.getText());
            } else {
                gameDetails = new GameDetails(this.money, this.health,
                        this.level, this.name.getText());
            }
            StoreGame.setGameDetails(gameDetails);
            gameScreen(e);
        }
    }

    protected void gameScreen(ActionEvent e) throws IOException {
        FXMLLoader gamePaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("game.fxml"));
        Parent gameScreen = gamePaneLoader.load();
        Scene gameScene = new Scene(gameScreen, 1200, 900);
        gameScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Game Landscape");
        stage.setScene(gameScene);
    }

}