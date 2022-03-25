package com.example.game;

//import javafx.animation.PathTransition;
import javafx.application.Platform;
//import javafx.concurrent.Service;
import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
//import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
//import javafx.util.Duration;

import java.io.IOException;
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
    private Button start;
    @FXML
    private Button[] backgroundButtonArray;
    @FXML
    private ImageView enemy;
    @FXML
    private ImageView enemy2;
    @FXML
    private VBox enemyBox;

    private Button[] temp = new Button[108];
    @FXML
    private GridPane map;
    private Circle circle;

    private GameDetails gameDetails;
    private Image quitImg;


    private static int time = 500;
    // METHOD 2
    //    private static boolean f1 = false;
    //    private static boolean f2 = false;
    //    private static  boolean f3 = false;
    //    private static boolean f4 = false;
    //    private static boolean f5 = false;
    //    private static boolean f6 = false;
    //    private static boolean f7 = false;
    //    private static boolean f8 = false;
    //    private static boolean f9 = false;
    //    private static boolean f10 = false;
    //    private static boolean f11 = false;
    //    private static boolean f12 = false;
    //    private static boolean f13 = false;
    //    private static boolean f14 = false;
    //    private static boolean f15 = false;
    //    private static boolean f16 = false;
    //    private static boolean f17 = false;
    //    private static boolean f18 = false;
    //    private static boolean f19 = false;
    //    private static boolean f20 = false;
    //    private static boolean f21 = false;
    //    private static boolean f22 = false;
    //    private static boolean f23 = false;
    //    private static boolean f24 = false;
    //    private static boolean f25 = false;
    private int pos;


    @FXML
    private void initialize() {
        URL enemyURL = TowerDefenseApplication.class.getResource("assets/images/enemy.png");
        Image enemyImage = new Image(String.valueOf(enemyURL));
        enemy.setImage(enemyImage);
        enemy.setFitWidth(50);
        enemy.setFitHeight(50);

        URL enemyURL2 = TowerDefenseApplication.class.getResource("assets/images/enemy2.png");
        Image enemyImage2 = new Image(String.valueOf(enemyURL2));
        enemy2.setImage(enemyImage2);
        enemy2.setFitWidth(50);
        enemy2.setFitHeight(50);
        gameDetails = StoreGame.getGameDetails();
        String level = StoreGame.getGameDetails().getLevel();
        backgroundButtonArray = StoreGame.getGameDetails().getBackgroundButton();
        if (gameDetails != null) {
            this.moneyText.setText("$" + gameDetails.getMoney());
            //this.moneyText.toFront();
            if (level.equals("EASY")) {
                this.healthText.setText("/ " + gameDetails.getEasyHealth());
                this.dynamicHealthText.setText(" " + gameDetails.getEasyHealth());
            } else if (level.equals("MEDIUM")) {
                this.healthText.setText("/ " + gameDetails.getMediumHealth());
                this.dynamicHealthText.setText(" " + gameDetails.getMediumHealth());
            } else if (level.equals("HARD")) {
                this.healthText.setText("/ " + gameDetails.getHardHealth());
                this.dynamicHealthText.setText(" " + gameDetails.getHardHealth());
            }
            this.start.setText("Start Game!");
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
                    } else if ((i == 0) && (j == 10)) {
                        start.setPrefSize(100, 100);
                        map.setRowIndex(start, 0);
                        map.setColumnIndex(start, 10);
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
        StoreGame.setGameDetails(null);
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
    protected void onPlay(ActionEvent e) throws Exception {
        // METHOD 1
        //        URL enemyURL = TowerDefenseApplication.class.getResource(
        //        "assets/images/enemy.png");
        //        Image enemyImage = new Image(String.valueOf(enemyURL));
        //        enemy.setImage(enemyImage);
        //        enemy.setFitWidth(50);
        //        enemy.setFitHeight(50);
        //        enemy.toFront();
        //        enemyBox.setPrefSize(80, 80);
        //        enemyBox.toFront();
        //        enemy.setFitHeight(80);
        //        enemy.setFitWidth(80);
        //        enemyBox.setPadding(new Insets(120, 0, 0, 0));
        //        PathTransition transition = new PathTransition();
        //        Polyline path = new Polyline();
        //        path.getPoints().addAll(0.0, 30.0,
        //                150.0, 30.0,
        //                150.0, 230.0,
        //                350.0, 230.0,
        //                350.0, 530.0,
        //                1050.0, 530.0,
        //                1050.0, 230.0,
        //                825.0, 230.0);
        //        transition.setNode(enemy);
        //        transition.setPath(path);
        //        if (StoreGame.getGameDetails().getLevel().equals("EASY")) {
        //            transition.setDuration(Duration.seconds(20));
        //        } else if (StoreGame.getGameDetails().getLevel().equals("MEDIUM")) {
        //            transition.setDuration(Duration.seconds(15));
        //        } else if (StoreGame.getGameDetails().getLevel().equals("HARD")) {
        //            transition.setDuration(Duration.seconds(10));
        //        }
        //        transition.setCycleCount(1);
        //        transition.play();

        // METHOD 2
        //        if (StoreGame.getGameDetails().getLevel().equals("EASY")) {
        //            time = 1500;
        //        } else if (StoreGame.getGameDetails().getLevel().equals("MEDIUM")) {
        //            time = 1000;
        //        } else if (StoreGame.getGameDetails().getLevel().equals("HARD")) {
        //            time = 500;
        //        }
        //        backgroundButtonArray[12].setGraphic(enemy);
        //        new SleepService(backgroundButtonArray, 13, enemy, dynamicHealthText).start();

        //METHOD 3
        start.setDisable(true);
        shop.setDisable(true);
        if (StoreGame.getGameDetails().getLevel().equals("EASY")) {
            time = 1500;
        } else if (StoreGame.getGameDetails().getLevel().equals("MEDIUM")) {
            time = 1000;
        } else if (StoreGame.getGameDetails().getLevel().equals("HARD")) {
            time = 500;
        }
        backgroundButtonArray[12].setGraphic(enemy);
        Thread.sleep(250);
        pos = 12;
        startCombat1();


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

    @FXML
    protected void onGameOver() throws java.io.IOException {
        FXMLLoader gameOVerLoader = new FXMLLoader(
                TowerDefenseApplication.class.getResource("gameover.fxml"));
        Parent gameOverPane = gameOVerLoader.load();
        Scene gameOverScene = new Scene(gameOverPane, 1200, 900);
        gameOverScene.getRoot().setStyle("-fx-font-family: 'Arial'");
        Stage stage = (Stage) map.getScene().getWindow();
        stage.setScene(gameOverScene);
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
    private void startCombat1() {
        Task task = new Task<Integer>() {
            @Override
            public Integer call() throws Exception {
                while (backgroundButtonArray[44].getGraphic() == null) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            backgroundButtonArray[pos].setGraphic(enemy);
                        }
                    });
                    if (pos == 12) {
                        pos = 13;
                    } else if (pos == 13) {
                        pos = 25;
                    } else if (pos == 25) {
                        pos = 37;
                    } else if (pos == 37) {
                        pos = 38;
                    } else if (pos == 38) {
                        pos = 39;
                    } else if (pos == 39) {
                        pos = 51;
                    } else if (pos == 51) {
                        pos = 63;
                    } else if (pos == 63) {
                        pos = 75;
                    } else if (pos == 75) {
                        pos = 76;
                    } else if (pos == 76) {
                        pos = 77;
                    } else if (pos == 77) {
                        pos = 78;
                    } else if (pos == 78) {
                        pos = 79;
                    } else if (pos == 79) {
                        pos = 80;
                    } else if (pos == 80) {
                        pos = 81;
                    } else if (pos == 81) {
                        pos = 82;
                    } else if (pos == 82) {
                        pos = 70;
                    } else if (pos == 70) {
                        pos = 58;
                    } else if (pos == 58) {
                        pos = 46;
                    } else if (pos == 46) {
                        pos = 45;
                    } else if (pos == 45) {
                        pos = 44;
                        towerAttack();
                    } else {

                        break;
                    }
                    Thread.sleep(time);
                }
                System.out.println(pos);
                System.out.println("end of loop");
                return pos;
            }
        };
        Thread combat = new Thread(task);
        combat.setDaemon(true);
        combat.start();
    }

    //    private void startCombat2() {
    //        Task task = new Task<Integer>() {
    //            @Override
    //            public Integer call() throws Exception {
    //                while (pos != 44) {
    //                    Platform.runLater(new Runnable() {
    //                        @Override
    //                        public void run() {
    //                            backgroundButtonArray[pos].setGraphic(enemy2);
    //                        }
    //                    });
    //                    if (pos == 12) {
    //                        pos = 13;
    //                    } else if (pos == 13 ) {
    //                        pos = 25;
    //                    } else if (pos == 25) {
    //                        pos = 37;
    //                    } else if (pos == 37) {
    //                        pos = 38;
    //                    } else if (pos == 38) {
    //                        pos = 39;
    //                    } else if (pos == 39 ) {
    //                        pos = 51;
    //                    } else if (pos == 51) {
    //                        pos = 63;
    //                    } else if (pos == 63) {
    //                        pos = 75;
    //                    } else if (pos == 75) {
    //                        pos = 76;
    //                    } else if (pos == 76 ) {
    //                        pos = 77;
    //                    } else if (pos == 77) {
    //                        pos = 78;
    //                    } else if (pos == 78) {
    //                        pos = 79;
    //                    } else if (pos == 79) {
    //                        pos = 80;
    //                    } else if (pos == 80 ) {
    //                        pos = 81;
    //                    } else if (pos == 81) {
    //                        pos = 82;
    //                    } else if (pos == 82) {
    //                        pos = 70;
    //                    } else if (pos == 70) {
    //                        pos = 58;
    //                    } else if (pos == 58) {
    //                        pos = 46;
    //                    } else if (pos == 46 ) {
    //                        pos = 45;
    //                    } else if (pos == 45) {
    //                        pos = 44;
    //                        towerAttack();
    //                    } else {
    //
    //                        break;
    //                    }
    //                    Thread.sleep(time);
    //                }
    //                System.out.println(pos);
    //                System.out.println("end of loop");
    //                return pos;
    //            }
    //        };
    //        Thread combat = new Thread(task);
    //        combat.setDaemon(true);
    //        combat.start();
    //    }

    private void towerAttack() {
        Task task = new Task<Integer>() {
            @Override
            public Integer call() throws Exception {
                while (StoreGame.getGameDetails().getHealth() > 0) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            StoreGame.getGameDetails().setHealth(gameDetails.getHealth() - 100);
                            dynamicHealthText.setText(" " + gameDetails.getHealth());
                            if (gameDetails.getHealth() <= 0) {
                                try {
                                    onGameOver();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    Thread.sleep(1500);
                }
                System.out.println("end of loop");

                return pos;
            }

        };
        Thread health = new Thread(task);
        health.setDaemon(true);
        health.start();
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
            URL url = TowerDefenseApplication.class.getResource(
                    "assets/images/NormalTower.png");
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
            URL url = TowerDefenseApplication.class.getResource(
                    "assets/images/EliteTower.png");
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
    //METHOD 2
    //    private static class SleepService extends Service<String>{
    //
    //        private SleepService(Button[] arr, int location,
    //          ImageView graphic, Label dynamicHealthText) {
    //
    //            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    //                @Override
    //                public void handle(WorkerStateEvent workerStateEvent) {
    //                    arr[location].setGraphic(graphic);
    //                    if (arr[13].getGraphic() != null && !f1) {
    //                        //System.out.println(arr[13].getGraphic() == null);
    //                        //System.out.println("F1:" + f1);
    //                        new SleepService(arr, 25, graphic, dynamicHealthText).start();
    //                        f1 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[25].getGraphic() != null && !f2) {
    //                       // System.out.println(arr[25].getGraphic() == null);
    //                       // System.out.println("F2:" + f2);
    //                        new SleepService(arr, 37, graphic, dynamicHealthText).start();
    //                        f2 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[37].getGraphic() != null && !f3) {
    //                       // System.out.println(arr[37].getGraphic() == null);
    //                       // System.out.println("F3:" + f3);
    //                        new SleepService(arr, 38, graphic, dynamicHealthText).start();
    //                        f3 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[38].getGraphic() != null && !f4) {
    ////                        System.out.println(arr[38].getGraphic() == null);
    ////                        System.out.println("F4:" + f4);
    //                        new SleepService(arr, 39, graphic, dynamicHealthText).start();
    //                        f4 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[39].getGraphic() != null && !f5) {
    ////                        System.out.println(arr[39].getGraphic() == null);
    ////                        System.out.println("F5:" + f5);
    //                        new SleepService(arr, 51, graphic, dynamicHealthText).start();
    //                        f5 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[51].getGraphic() != null && !f6) {
    ////                        System.out.println(arr[51].getGraphic() == null);
    ////                        System.out.println(f6);
    //                        new SleepService(arr, 63, graphic, dynamicHealthText).start();
    //                        f6 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[63].getGraphic() != null && !f7) {
    ////                        System.out.println(arr[63].getGraphic() == null);
    ////                        System.out.println(f7);
    //                        new SleepService(arr, 75, graphic, dynamicHealthText).start();
    //                        f7 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //
    //                    if (arr[75].getGraphic() != null && !f8) {
    ////                        System.out.println(arr[75].getGraphic() == null);
    ////                        System.out.println(f8);
    //                        new SleepService(arr, 76, graphic, dynamicHealthText).start();
    //                        f8 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[76].getGraphic() != null && !f9) {
    ////                        System.out.println(arr[76].getGraphic() == null);
    ////                        System.out.println(f9);
    //                        new SleepService(arr, 77, graphic, dynamicHealthText).start();
    //                        f9 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[77].getGraphic() != null && !f10) {
    ////                        System.out.println(arr[13].getGraphic() == null);
    ////                        System.out.println(f10);
    //                        new SleepService(arr, 78, graphic, dynamicHealthText).start();
    //                        f10 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //
    //                    if (arr[78].getGraphic() != null && !f11) {
    ////                        System.out.println(arr[78].getGraphic() == null);
    ////                        System.out.println(f11);
    //                        new SleepService(arr, 79, graphic, dynamicHealthText).start();
    //                        f11 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[79].getGraphic() != null && !f12) {
    ////                        System.out.println(arr[79].getGraphic() == null);
    ////                        System.out.println(f12);
    //                        new SleepService(arr, 80, graphic, dynamicHealthText).start();
    //                        f12 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[80].getGraphic() != null && !f13) {
    ////                        System.out.println(arr[80].getGraphic() == null);
    ////                        System.out.println(f13);
    //                        new SleepService(arr, 81, graphic, dynamicHealthText).start();
    //                        f13 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[81].getGraphic() != null && !f14) {
    ////                        System.out.println(arr[81].getGraphic() == null);
    ////                        System.out.println(f14);
    //                        new SleepService(arr, 82, graphic, dynamicHealthText).start();
    //                        f14 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[82].getGraphic() != null && !f15) {
    ////                        System.out.println(arr[82].getGraphic() == null);
    ////                        System.out.println(f15);
    //                        new SleepService(arr, 70, graphic, dynamicHealthText).start();
    //                        f13 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[70].getGraphic() != null && !f16) {
    ////                        System.out.println(arr[70].getGraphic() == null);
    ////                        System.out.println(f16);
    //                        new SleepService(arr, 58, graphic, dynamicHealthText).start();
    //                        f16 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //
    //                    }
    //                    if (arr[58].getGraphic() != null && !f17) {
    ////                        System.out.println(arr[58].getGraphic() == null);
    ////                        System.out.println(f17);
    //                        new SleepService(arr, 46, graphic, dynamicHealthText).start();
    //                        f17 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[46].getGraphic() != null && !f18) {
    ////                        System.out.println(arr[46].getGraphic() == null);
    ////                        System.out.println(f18);
    //                        new SleepService(arr, 45, graphic, dynamicHealthText).start();
    //                        f18 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //                    if (arr[45].getGraphic() != null && !f19) {
    ////                        System.out.println(arr[45].getGraphic() == null);
    ////                        System.out.println(f19);
    //                        new SleepService(arr, 44, graphic, dynamicHealthText).start();
    //                        f19 = true;
    //                        boolean ho = cancel();
    //                        System.out.println("CANCEL:" + ho);
    //                    }
    //
    //                    //System.out.println(workerStateEvent.getSource().
    //                    getValue() + " " + location);
    //                }
    //            });
    //        }
    //        @Override
    //        protected Task<String> createTask() {
    //            return new Task<String>() {
    //                @Override
    //                protected String call() throws Exception {
    //                    try {
    //                        Thread.sleep(time);
    //                    } catch (InterruptedException interrupted) {
    //                        if (isCancelled()) {
    //                            updateMessage("Cancelled");
    //                            System.out.println("CANCELLED: "+ isCancelled());
    //                        }
    //                    }
    //                    return "Hi";
    //                }
    //            };
    //        }
    //    }


}
