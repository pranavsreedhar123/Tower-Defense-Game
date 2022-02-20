package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TowerDefenseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TowerDefenseApplication.class.getResource("welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
        scene.getRoot().setStyle("-fx-font-family: 'Arial'");
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}