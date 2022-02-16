package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


public class LandscapeController {
    @FXML
    private Label moneyText;

    private Integer EASY_MONEY = 500;
    private Integer MEDIUM_MONEY = 250;
    private Integer HARD_MONEY = 100;


    @FXML
    private void initialize() {

    }

    public void setMoney(String difficulty) {
        this.moneyText.setTextFill(Color.GREEN);

        if (difficulty.equals("EASY")) {
            this.moneyText.setText("MONEY: " + this.EASY_MONEY.toString());
        } else if (difficulty.equals("MEDIUM")) {
            this.moneyText.setText("MONEY: " + this.MEDIUM_MONEY.toString());
        } else if (difficulty.equals("HARD")) {
            this.moneyText.setText("MONEY: " + this.HARD_MONEY.toString());
        }
    }
}
