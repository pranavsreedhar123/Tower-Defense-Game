package com.example.game;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GameDetails {
    private String name;
    private String level;
    private String image;
    private int money;
    private int health;
    private final int easyHealth = 3000;
    private final int mediumHealth = 2000;
    private final int hardHealth = 1000;
    private Button[] backgroundButton = new Button[108];
    private GridPane map;
    private HashMap<Integer, Integer> pathPositionMappedToDamage;
    private HashSet<Integer> pathLocations;
    private int extraMoney = 0;



    public GameDetails(int money, int health, String level, String name) {
        this.money = money;
        this.level = level;
        this.health = health;
        this.name = name;
        pathPositionMappedToDamage = new HashMap<>();

        // 12, 13, 25, 37, 38, 39, 51, 63, 75, 76, 77, 78, 79, 80, 81, 82, 70, 58, 46, 45, 44
        pathLocations = new HashSet<>();
        pathLocations.add(12);
        pathLocations.add(13);
        pathLocations.add(25);
        pathLocations.add(37);
        pathLocations.add(38);
        pathLocations.add(39);
        pathLocations.add(51);
        pathLocations.add(63);
        pathLocations.add(75);
        pathLocations.add(76);
        pathLocations.add(77);
        pathLocations.add(78);
        pathLocations.add(79);
        pathLocations.add(80);
        pathLocations.add(81);
        pathLocations.add(82);
        pathLocations.add(70);
        pathLocations.add(58);
        pathLocations.add(46);
        pathLocations.add(45);
        pathLocations.add(44);

        for (int i : pathLocations) {
            pathPositionMappedToDamage.put(i, 0);
        }

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
    public void setImage(String image) {
        this.image = image;
    }
    public void setBackgroundButton(Button[] backgroundButton) {
        this.backgroundButton = backgroundButton;
    }
    public void setMap(GridPane map) {
        this.map = map;
    }
    public int getMoney() {

        return money;
    }
    public int getEasyHealth() {
        return easyHealth;
    }
    public int getMediumHealth() {
        return mediumHealth;
    }
    public int getHardHealth() {
        return hardHealth;
    }
    public int getHealth() {
        return health;
    }
    public String getLevel() {
        return level;
    }
    public String getImage() {
        return image;
    }
    public Button[] getBackgroundButton() {
        return backgroundButton;
    }
    public GridPane getMap() {
        return  map;
    }
    public void updateTowerDamages(Map<Integer, Integer> update) {
        for (int position : update.keySet()) {
            pathPositionMappedToDamage.replace(position,
                    pathPositionMappedToDamage.get(position) + update.get(position));
        }
    }
    public Map<Integer, Integer> getDamages() {
        return pathPositionMappedToDamage;
    }
    public void setExtraMoney(int amount) {
        extraMoney += amount;
    }
    public int getExtraMoney() {
        return extraMoney;
    }
}
