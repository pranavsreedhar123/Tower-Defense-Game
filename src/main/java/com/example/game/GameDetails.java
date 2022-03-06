package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameDetails {
    private String name;
    private String level;
    private String image;
    private int money;
    private int health;
    private Button[] backgroundButton = new Button[108];
    private GridPane map;

    public GameDetails(int money, int health, String level, String name) {
        this.money = money;
        this.level = level;
        this.health = health;
        this.name = name;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {this.image = image; }
    public void setBackgroundButton(Button[] backgroundButton) {this.backgroundButton = backgroundButton;}
    public void setMap(GridPane map) {this.map = map;}
    public int getMoney() {
        return money;
    }
    public int getHealth() {
        return health;
    }
    public String getLevel() {
        return level;
    }
    public String getImage() { return image; }
    public Button[] getBackgroundButton() { return backgroundButton; }
    public GridPane getMap() { return  map;}
}
