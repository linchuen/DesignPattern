package org.example.BehavioralPatterns.Template.after;

import org.example.BehavioralPatterns.Template.object.Player;
import org.example.BehavioralPatterns.Template.object.PlayerInfo;
import org.example.BehavioralPatterns.Template.object.PlayerType;

public class TemplateGuest implements Player {
    private final PlayerCommonBehavior playerCommonBehavior;

    public TemplateGuest(PlayerCommonBehavior playerCommonBehavior) {
        this.playerCommonBehavior = playerCommonBehavior;
    }

    @Override
    public PlayerInfo buildPlayer(String name) {
        return playerCommonBehavior.buildPlayer(name, 99, PlayerType.Guest);
    }

    @Override
    public void playGuessNumberGame(PlayerInfo playerInfo, int range) {
        playerCommonBehavior.playGuessNumberGame(playerInfo, range);
    }

    @Override
    public void guessNumber(PlayerInfo playerInfo, int number) {
        playerCommonBehavior.guessNumber(playerInfo, number, false);
    }

    @Override
    public void quitGame(PlayerInfo playerInfo) {
        playerCommonBehavior.quitGame(playerInfo);
    }
}
