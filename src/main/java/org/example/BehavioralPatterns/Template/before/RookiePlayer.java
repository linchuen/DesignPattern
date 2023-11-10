package org.example.BehavioralPatterns.Template.before;

import org.example.BehavioralPatterns.Template.object.GameInfo;
import org.example.BehavioralPatterns.Template.object.GuessNumberGame;
import org.example.BehavioralPatterns.Template.object.Player;
import org.example.BehavioralPatterns.Template.object.PlayerInfo;
import org.example.BehavioralPatterns.Template.object.PlayerType;

public class RookiePlayer implements Player {
    private final GuessNumberGame guessNumberGame;

    public RookiePlayer(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    @Override
    public PlayerInfo buildPlayer(String name) {
        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.setName(name);
        playerInfo.setMaxGuessTimes(5);
        playerInfo.setType(PlayerType.Rookie);
        return playerInfo;
    }

    @Override
    public void playGuessNumberGame(PlayerInfo playerInfo, int range) {
        GameInfo gameInfo = guessNumberGame.initGame(range);
        playerInfo.setCurrentGame(gameInfo);
    }

    @Override
    public void guessNumber(PlayerInfo playerInfo, int number) {
        boolean isRepeat = guessNumberGame.checkNumberIsRepeat(playerInfo.getCurrentGame(), number);
        if (isRepeat) return;

        System.out.print(playerInfo.getName() + " 猜 " + number + " ");
        int currentGuessTimes = playerInfo.getCurrentGuessTimes() + 1;
        playerInfo.setCurrentGuessTimes(currentGuessTimes);

        boolean isAchieveMaxGuessTime = currentGuessTimes == playerInfo.getMaxGuessTimes();

        boolean isCorrect = guessNumberGame.checkResult(playerInfo.getCurrentGame(), number);
        if (isCorrect) {
            System.out.println("\n猜對了 正確數字是:" + number);
            guessNumberGame.sendAward(playerInfo);
            quitGame(playerInfo);
        } else if (isAchieveMaxGuessTime) {
            System.out.println("已到達最大猜測數");
            quitGame(playerInfo);
        } else {
            System.out.println("請繼續努力");
        }
    }

    @Override
    public void quitGame(PlayerInfo playerInfo) {
        playerInfo.setCurrentGame(null);
        System.out.println(playerInfo.getName() +" 離開遊戲");
    }
}
