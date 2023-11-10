package org.example.BehavioralPatterns.Template.object;

public interface Player {
    PlayerInfo buildPlayer(String name);

    void playGuessNumberGame(PlayerInfo playerInfo, int range);

    void guessNumber(PlayerInfo playerInfo, int number);

    void quitGame(PlayerInfo playerInfo);
}
