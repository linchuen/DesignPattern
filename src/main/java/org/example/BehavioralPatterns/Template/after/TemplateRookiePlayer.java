package org.example.BehavioralPatterns.Template.after;

import org.example.BehavioralPatterns.Template.object.Player;
import org.example.BehavioralPatterns.Template.object.PlayerInfo;
import org.example.BehavioralPatterns.Template.object.PlayerType;

public class TemplateRookiePlayer implements Player {
    private final PlayerCommonBehavior playerCommonBehavior;

    public TemplateRookiePlayer(PlayerCommonBehavior playerCommonBehavior) {
        this.playerCommonBehavior = playerCommonBehavior;
    }

    @Override
    public PlayerInfo buildPlayer(String name) {
        return playerCommonBehavior.buildPlayer(name, 5, PlayerType.Rookie);
    }

    @Override
    public void playGuessNumberGame(PlayerInfo playerInfo, int range) {
        playerCommonBehavior.playGuessNumberGame(playerInfo, range);
    }

    @Override
    public void guessNumber(PlayerInfo playerInfo, int number) {
        playerCommonBehavior.guessNumber(playerInfo, number, true);
    }

    @Override
    public void quitGame(PlayerInfo playerInfo) {
        playerCommonBehavior.quitGame(playerInfo);
    }
}
