package com.example.game;

public class StoreGame {
    private static GameDetails gameDetails = null;

    public static GameDetails getGameDetails() {
        return gameDetails;
    }

    public static void setGameDetails(GameDetails game) {
        StoreGame.gameDetails = game;
    }
}
