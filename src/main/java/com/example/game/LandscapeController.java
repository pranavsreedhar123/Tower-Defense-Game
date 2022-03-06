package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
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
    private Button[] backgroundButtonArray;
    private Button[] temp = new Button[108];
    @FXML
    private GridPane map;

    private GameDetails gameDetails;
    private Image quitImg;




    @FXML
    private void initialize() {
        gameDetails = StoreGame.getGameDetails();
        String level = StoreGame.getGameDetails().getLevel();
        backgroundButtonArray = StoreGame.getGameDetails().getBackgroundButton();
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

                    if ((i == 0) && (j == 0)) {
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
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 2 || i == 3) && (j == 1)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 3) && (j == 2 || j == 3)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 4 || i == 5 || i == 6) && (j == 3)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 6) && (j == 4 || j == 5 || j == 6 || j == 7
                            || j == 8 || j == 9 || j == 10)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 3 || i == 4 || i == 5) && (j == 10)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 3) && (j == 8 || j == 9)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #0000ff; -fx-background-radius: 0");
                    } else if ((i == 2 || i == 4) && (j == 7 || j == 6)) {
                        backgroundButton.setStyle(
                                "-fx-background-color: #ff0000; -fx-background-radius: 0");
                    } else if ((i == 3) && (j == 6)) {
                        dynamicHealthText.setStyle("-fx-background-color: #ff0000");
                        map.setRowIndex(dynamicHealthText, 3);
                        map.setColumnIndex(dynamicHealthText, 6);
                        continue;
                    } else {
                        if (backgroundButtonArray[12 * i + j] != null
                                && backgroundButtonArray[12 * i + j].getGraphic() == null) {
                            backgroundButton.setStyle(
                                    "-fx-background-color: #00ff00; -fx-background-radius: 0");
                        } else if (backgroundButtonArray[12 * i + j] == null) {
                            backgroundButton.setStyle(
                                    "-fx-background-color: #00ff00; -fx-background-radius: 0");
                        } else {
                            backgroundButton.setGraphic(
                                    backgroundButtonArray[12 * i + j].getGraphic());
                        }
                        backgroundButton.setOnAction(e -> {
                            if (StoreGame.getGameDetails().getImage().equals("normal")) {
                                placeTower(backgroundButton, "normal");
                            } else if (StoreGame.getGameDetails().getImage().equals("elite")) {
                                placeTower(backgroundButton, "elite");
                            } else if (StoreGame.getGameDetails().getImage().equals("bad")) {
                                placeTower(backgroundButton, "bad");
                            }
                        });
                    }
                    map.add(backgroundButton, j, i);
                    backgroundButtonArray[12 * i + j] = backgroundButton;
                    StoreGame.getGameDetails().setBackgroundButton(backgroundButtonArray);
                }
            }
        }
    }



    @FXML
    protected void onHomeScreen(ActionEvent e) throws java.io.IOException {
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
    protected void onShop(ActionEvent e) throws java.io.IOException {
        FXMLLoader configPaneLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("shop.fxml"));
        Parent configScreen = configPaneLoader.load();
        Scene configScene = new Scene(configScreen, 1200, 900);
        configScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setTitle("Shop");
        stage.setScene(configScene);
    }

    protected void clickTower() throws java.io.IOException {
        for (Button button: StoreGame.getGameDetails().getBackgroundButton()) {
            if (button != null) {
                if (button.getStyle().equals(
                        "-fx-background-color: #00ff00; -fx-background-radius: 0")) {
                    button.setOnAction(e -> {
                        if (StoreGame.getGameDetails().getImage().equals("normal")) {
                            placeTower(button, "normal");
                        } else if (StoreGame.getGameDetails().getImage().equals("elite")) {
                            placeTower(button, "elite");
                        } else if (StoreGame.getGameDetails().getImage().equals("bad")) {
                            placeTower(button, "bad");
                        }


                    });
                }
            }
        }
    }
    protected void placeTower(Button backgroundButton, String tower)  {
        String[] id = backgroundButton.getId().split(",");
        System.out.println(backgroundButton.getStyle());
        int row = Integer.parseInt(id[0]);
        int col = Integer.parseInt(id[1]);
        if (tower.equals("bad")) {
            URL url = TowerDefenseApplication.class.getResource("assets/images/BadTower.png");
            Image towerImg = new Image(String.valueOf(url));

            ImageView towerImgView = new ImageView();
            towerImgView.setImage(towerImg);
            //quit.setMaxSize(100, 100);
            towerImgView.setFitHeight(100);
            towerImgView.setFitWidth(92);
            towerImgView.setPreserveRatio(true);
            backgroundButton.setGraphic(towerImgView);
            backgroundButtonArray[12 * row + col] = backgroundButton;
            StoreGame.getGameDetails().setBackgroundButton(backgroundButtonArray);
        } else if (tower.equals("normal")) {
            URL url = TowerDefenseApplication.class.getResource("assets/images/NormalTower.png");
            Image towerImg = new Image(String.valueOf(url));

            ImageView towerImgView = new ImageView();
            towerImgView.setImage(towerImg);
            //quit.setMaxSize(100, 100);
            towerImgView.setFitHeight(100);
            towerImgView.setFitWidth(92);
            towerImgView.setPreserveRatio(true);
            backgroundButton.setGraphic(towerImgView);
            backgroundButtonArray[12 * row + col] = backgroundButton;
            StoreGame.getGameDetails().setBackgroundButton(backgroundButtonArray);
        } else if (tower.equals("elite")) {
            URL url = TowerDefenseApplication.class.getResource("assets/images/EliteTower.png");
            Image towerImg = new Image(String.valueOf(url));

            ImageView towerImgView = new ImageView();
            towerImgView.setImage(towerImg);
            //quit.setMaxSize(100, 100);
            towerImgView.setFitHeight(100);
            towerImgView.setFitWidth(92);
            towerImgView.setPreserveRatio(true);
            backgroundButton.setGraphic(towerImgView);
            backgroundButtonArray[12 * row + col] = backgroundButton;
            StoreGame.getGameDetails().setBackgroundButton(backgroundButtonArray);
        }
        //quit.requestFocus();
        //towerImgView.setImage(towerImg);
        System.out.println(row);
        System.out.println(col);
        map.setRowIndex(backgroundButton, row);
        map.setColumnIndex(backgroundButton, col);
        StoreGame.getGameDetails().setImage("");
        //disableTowerButtons();
        //backgroundButton.setStyle("-fx-background-color: #ff0000");

        //quit.toFront();
    }

    protected void disableTowerButtons() {
        for (Button b: backgroundButtonArray) {
            if (b != null) {
                b.setDisable(true);
            }
        }
    }

}
