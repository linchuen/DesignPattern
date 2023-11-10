package org.example.BehavioralPatterns.Template.object;

public interface GuessNumberGame {
    GameInfo initGame(int range);

    int generateNumber(int range);

    boolean checkNumberIsRepeat(GameInfo gameInfo, int number);

    boolean checkResult(GameInfo gameInfo, int number);

    void sendAward(PlayerInfo playerInfo);
}
