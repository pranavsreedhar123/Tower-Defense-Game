package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


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
    protected void onEasy(ActionEvent e) { level = "EASY"; }
    @FXML
    protected void onMedium(ActionEvent e) {
        level = "MEDIUM";
    }
    @FXML
    protected void onHard(ActionEvent e) {
        level = "HARD";
    }
    @FXML
    protected void onBegin(ActionEvent e) throws IOException {
        if (name.getText().isBlank() || name.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please write a valid name");
            //alert.getDialogPane().setExpandableContent(new Label("Please write a valid name"));
            alert.showAndWait();
        } else if (level.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please choose a valid level");
            //alert.getDialogPane().setExpandableContent(new Label("Please choose a valid level"));
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Name: " + name.getText() + "\nLevel: " + level);
            //alert.getDialogPane().setExpandableContent(new Label("Name: " + name.getText() + "\nLevel: " + level));
            alert.showAndWait();
            gameScreen(e);
        }
    }

    protected void gameScreen(ActionEvent e) throws IOException {
        FXMLLoader gamePaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("game.fxml"));
        Parent gameScreen = gamePaneLoader.load();

        LandscapeController child = gamePaneLoader.getController();
        child.setMoney(this.level);

        Scene gameScene = new Scene(gameScreen, 500, 500);
        gameScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Game Landscape");
        stage.setScene(gameScene);
    }

}