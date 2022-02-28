package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Group;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;

//import java.io.IOException;
import java.net.URL;


public class LandscapeController {

    @FXML
    private Label moneyText;
    @FXML
    private Label healthText;
    @FXML
    private Label dynamicHealthText;
    @FXML
    private Button quit;
    @FXML
    private Button shop;
    @FXML
    private GridPane map;

    private GameDetails gameDetails;
    private Image quitImg;


    @FXML
    private void initialize() {
        gameDetails = StoreGame.getGameDetails();
        String level = StoreGame.getGameDetails().getLevel();
        if (gameDetails != null) {
            this.moneyText.setText("$" + gameDetails.getMoney());
            //this.moneyText.toFront();
            this.healthText.setText("/ " + gameDetails.getHealth());
            this.dynamicHealthText.setText(" " + gameDetails.getHealth());

            this.shop.requestFocus();
            this.shop.setText("Open Shop!");
            try {
                URL url = TowerDefenseApplication.class.getResource("assets/images/Quit.png");
                quitImg = new Image(String.valueOf(url));
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error in accessing assets");
                alert.show();
            }
            for (int i = 0; i < 9; i++) {
                RowConstraints rowConstraints = new RowConstraints(100);
                map.getRowConstraints().add(rowConstraints);
            }
            for (int j = 0; j < 12; j++) {
                ColumnConstraints columnConstraints = new ColumnConstraints(100);
                map.getColumnConstraints().add(columnConstraints);
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 12; j++) {
                    Button backgroundButton = new Button();
                    backgroundButton.setId(i + "," + j);
                    backgroundButton.setPrefSize(100, 100);
                    if ((i == 0 ) && (j == 0)) {
                        ImageView quitImgView = new ImageView();
                        quitImgView.setImage(quitImg);
                        quit.setMaxSize(100, 100);
                        quitImgView.setFitHeight(100);
                        quitImgView.setFitWidth(92);
                        quitImgView.setPreserveRatio(true);
                        quit.setGraphic(quitImgView);
                        quit.requestFocus();
                        quitImgView.setImage(quitImg);
                        quit.setStyle("-fx-background-color: #ff0000");
                        quit.toFront();
                        continue;
                    } else if ((i == 0) && (j == 11)) {
                       // structure.setAlignment(moneyText, Pos.TOP_RIGHT);
                        //shop.setStyle("-fx-background-color: #00ff00");
                        shop.setPrefSize(100, 100);
                        map.setRowIndex(shop, 0);
                        map.setColumnIndex(shop, 11);
                        continue;
                    } else if ((i == 1) && (j == 11)) {
                        // structure.setAlignment(moneyText, Pos.TOP_RIGHT);
                        moneyText.setStyle("-fx-background-color: #00ff00");
                        map.setRowIndex(moneyText, 1);
                        map.setColumnIndex(moneyText, 11);
                        continue;
                    } else if ((i == 3) && (j == 7)) {
                        healthText.setStyle("-fx-background-color: #ff0000");
                        map.setRowIndex(healthText, 3);
                        map.setColumnIndex(healthText, 7);
                        continue;
                    } else if ((i == 1) && (j == 0 || j == 1)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    }  else if ((i == 2 || i == 3) && (j == 1)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 3) && (j == 2 || j == 3)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 4 || i == 5 || i == 6) && (j == 3)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 6 ) && (j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 3 || i == 4 || i == 5) && (j == 10)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 3) && (j == 8 || j == 9)) {
                        backgroundButton.setStyle("-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 2 || i == 4) && (j == 7 || j == 6)) {
                        backgroundButton.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 0");
                    } else if ((i == 3) && (j == 6)) {
                        dynamicHealthText.setStyle("-fx-background-color: #ff0000");
                        map.setRowIndex(dynamicHealthText, 3);
                        map.setColumnIndex(dynamicHealthText, 6);
                        continue;
                    }  else {
                       backgroundButton.setStyle("-fx-background-color: #00ff00; -fx-background-radius: 0");
                    }
                    map.add(backgroundButton, j, i);
                }
            }
        }
    }

    @FXML
    protected void onHomeScreen(ActionEvent e) throws java.io.IOException {
        FXMLLoader configPaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("configuration.fxml"));
        Parent configScreen = configPaneLoader.load();
        Scene configScene = new Scene(configScreen, 1200, 1000);
        configScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Configuration");
        stage.setScene(configScene);
    }

    @FXML
    protected void onShop(ActionEvent e) throws java.io.IOException {
        FXMLLoader configPaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("shop.fxml"));
        Parent configScreen = configPaneLoader.load();
        Scene configScene = new Scene(configScreen, 1200, 1000);
        configScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Shop");
        stage.setScene(configScene);
    }
}
