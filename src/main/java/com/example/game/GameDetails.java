package com.example.game;

public class GameDetails {
    private String name;
    private String level;
    private int money;

    public GameDetails(int money, String level, String name) {
        this.money = money;
        this.level = level;
        this.name = name;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMoney() {
        return money;
    }
    public String getLevel() {
        return level;
    }
}
