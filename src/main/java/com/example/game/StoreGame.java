package com.example.game;

public class StoreGame {
    private static GameDetails gameDetails;

    public static GameDetails getGameDetails() {
        return gameDetails;
    }

    public static void setGameDetails(GameDetails game) {
        StoreGame.gameDetails = game;
    }
}
