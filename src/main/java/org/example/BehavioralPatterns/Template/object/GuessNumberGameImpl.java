package org.example.BehavioralPatterns.Template.object;

import org.example.BehavioralPatterns.Template.object.PlayerInfo;
import org.example.BehavioralPatterns.Template.object.GameInfo;
import org.example.BehavioralPatterns.Template.object.GuessNumberGame;

import java.security.SecureRandom;
import java.util.Random;

public class GuessNumberGameImpl implements GuessNumberGame {
    private final Random random = new SecureRandom();

    @Override
    public GameInfo initGame(int range) {
        GameInfo gameInfo = new GameInfo(range);
        int randomNumber = generateNumber(range);
        gameInfo.setNumber(randomNumber);
        return gameInfo;
    }

    @Override
    public int generateNumber(int range) {
        return random.nextInt(range);
    }

    @Override
    public boolean checkNumberIsRepeat(GameInfo gameInfo, int number) {
        return gameInfo.getGuessedNumber().contains(number);
    }

    @Override
    public boolean checkResult(GameInfo gameInfo, int number) {
        gameInfo.addGuessedNumber(number);
        return gameInfo.getNumber() == number;
    }

    @Override
    public void sendAward(PlayerInfo playerInfo) {
        System.out.println("玩家" + playerInfo.getName() + "贏得獎勵");
    }
}
