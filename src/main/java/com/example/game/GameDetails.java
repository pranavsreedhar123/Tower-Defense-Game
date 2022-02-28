package com.example.game;

public class GameDetails {
    private String name;
    private String level;
    private int money;
    private int health;

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
    public int getMoney() {
        return money;
    }
    public int getHealth() {
        return health;
    }
    public String getLevel() {
        return level;
    }
}
