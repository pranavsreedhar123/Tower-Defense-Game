package com.example.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label developersText;

    @FXML
    protected void onPlayButtonClick() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WelcomeController.class.getResource("configuration.fxml"));
        Scene next = new Scene(fxmlLoader.load(), 320, 240);
    }

    @FXML
    protected void onQuitButtonClick() {
        javafx.application.Platform.exit();
        System.exit(0);
    }

    @FXML
    public void initialize() {
        this.welcomeText.setText("Welcome to Tower Defense!");
        this.developersText.setText("Developed by: Big-O-micron");
    }
}