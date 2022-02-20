package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
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

    private GameDetails gameDetails;
    private int money;

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
        money = 500;
    }
    @FXML
    protected void onMedium(ActionEvent e) {
        level = "MEDIUM";
        money = 250;
    }
    @FXML
    protected void onHard(ActionEvent e) {
        level = "HARD";
        money = 100;
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
            gameDetails = new GameDetails(this.money, this.level, this.name.getText());
            StoreGame.setGameDetails(gameDetails);
            gameScreen(e);
        }
    }

    protected void gameScreen(ActionEvent e) throws IOException {
        FXMLLoader gamePaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("game.fxml"));
        Parent gameScreen = gamePaneLoader.load();
        Scene gameScene = new Scene(gameScreen, 1000, 1000);
        gameScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Game Landscape");
        stage.setScene(gameScene);





//        Image image = new Image("https://lv7ms1pq6dm2sea8j1mrajzw-wpengine.netdna-ssl.com/wp-content/uploads/2020/09/GT-1200x675.jpg");
//
//        //Setting the image view
//        ImageView imageView = new ImageView(image);
//
//        //Setting the position of the image
//        imageView.setX(50);
//        imageView.setY(25);
//
//        //setting the fit height and width of the image view
//        imageView.setFitHeight(455);
//        imageView.setFitWidth(500);
//
//        //Setting the preserve ratio of the image view
//        imageView.setPreserveRatio(true);
//
//        //Creating a Group object
//        Group root = new Group(imageView);
//
//
//        Scene gameScene = new Scene(root, 500, 500);
//        gameScene.getRoot().setStyle("-fx-font-family: 'Arial'");
//        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//        stage.setTitle("Game Landscape");
//        stage.setScene(gameScene);
    }

}