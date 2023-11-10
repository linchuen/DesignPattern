package org.example.BehavioralPatterns.Template.object;

import org.example.BehavioralPatterns.Template.object.GameInfo;
import org.example.BehavioralPatterns.Template.object.PlayerType;

public class PlayerInfo {
    private String name;
    private PlayerType type;
    private int maxGuessTimes;

    private int currentGuessTimes;

    private GameInfo currentGame;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public int getMaxGuessTimes() {
        return maxGuessTimes;
    }

    public void setMaxGuessTimes(int maxGuessTimes) {
        this.maxGuessTimes = maxGuessTimes;
    }

    public GameInfo getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(GameInfo currentGame) {
        this.currentGame = currentGame;
    }

    public int getCurrentGuessTimes() {
        return currentGuessTimes;
    }

    public void setCurrentGuessTimes(int currentGuessTimes) {
        this.currentGuessTimes = currentGuessTimes;
    }

}
