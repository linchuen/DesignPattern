package org.example.BehavioralPatterns.Template.after;

import org.example.BehavioralPatterns.Template.object.GameInfo;
import org.example.BehavioralPatterns.Template.object.GuessNumberGame;
import org.example.BehavioralPatterns.Template.object.PlayerInfo;
import org.example.BehavioralPatterns.Template.object.PlayerType;

public class PlayerCommonBehavior {
    private final GuessNumberGame guessNumberGame;

    public PlayerCommonBehavior(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public PlayerInfo buildPlayer(String name, int maxTimes, PlayerType playerType) {
        PlayerInfo playerInfo = new PlayerInfo();
        playerInfo.setName(name);
        playerInfo.setMaxGuessTimes(maxTimes);
        playerInfo.setType(playerType);
        return playerInfo;
    }

    public void playGuessNumberGame(PlayerInfo playerInfo, int range) {
        GameInfo gameInfo = guessNumberGame.initGame(range);
        playerInfo.setCurrentGame(gameInfo);
    }

    public void guessNumber(PlayerInfo playerInfo, int number, boolean isSendAward) {
        boolean isRepeat = guessNumberGame.checkNumberIsRepeat(playerInfo.getCurrentGame(), number);
        if (isRepeat) return;

        System.out.print(playerInfo.getName() + " 猜 " + number + " ");
        int currentGuessTimes = playerInfo.getCurrentGuessTimes() + 1;
        playerInfo.setCurrentGuessTimes(currentGuessTimes);

        boolean isAchieveMaxGuessTime = currentGuessTimes == playerInfo.getMaxGuessTimes();

        boolean isCorrect = guessNumberGame.checkResult(playerInfo.getCurrentGame(), number);
        if (isCorrect) {
            System.out.println("\n猜對了 正確數字是:" + number);
            if (isSendAward) {
                guessNumberGame.sendAward(playerInfo);
            }
            quitGame(playerInfo);
        } else if (isAchieveMaxGuessTime) {
            System.out.println("已到達最大猜測數");
            quitGame(playerInfo);
        } else {
            System.out.println("請繼續努力");
        }
    }

    public void quitGame(PlayerInfo playerInfo) {
        playerInfo.setCurrentGame(null);
        System.out.println(playerInfo.getName() + " 離開遊戲");
    }
}
