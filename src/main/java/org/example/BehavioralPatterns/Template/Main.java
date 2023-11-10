package org.example.BehavioralPatterns.Template;

import org.example.BehavioralPatterns.Template.after.PlayerCommonBehavior;
import org.example.BehavioralPatterns.Template.after.TemplateGuest;
import org.example.BehavioralPatterns.Template.after.TemplateRookiePlayer;
import org.example.BehavioralPatterns.Template.after.TemplateSeniorPlayer;
import org.example.BehavioralPatterns.Template.before.Guest;
import org.example.BehavioralPatterns.Template.before.RookiePlayer;
import org.example.BehavioralPatterns.Template.before.SeniorPlayer;
import org.example.BehavioralPatterns.Template.object.GuessNumberGame;
import org.example.BehavioralPatterns.Template.object.GuessNumberGameImpl;
import org.example.BehavioralPatterns.Template.object.Player;
import org.example.BehavioralPatterns.Template.object.PlayerInfo;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        GuessNumberGame guessNumberGame = new GuessNumberGameImpl();

        System.out.println("before");
        Player guest = new Guest(guessNumberGame);
        Player rookie = new RookiePlayer(guessNumberGame);
        Player senior = new SeniorPlayer(guessNumberGame);

        PlayerInfo guestInfo = guest.buildPlayer("遊客");
        guest.playGuessNumberGame(guestInfo, 5);
        while (guestInfo.getCurrentGame() != null) {
            guest.guessNumber(guestInfo, new Random().nextInt(5));
        }
        System.out.println();

        PlayerInfo rookieInfo = rookie.buildPlayer("初級玩家");
        rookie.playGuessNumberGame(rookieInfo, 5);
        while (rookieInfo.getCurrentGame() != null) {
            rookie.guessNumber(rookieInfo, new Random().nextInt(5));
        }
        System.out.println();

        PlayerInfo seniorInfo = senior.buildPlayer("高級玩家");
        senior.playGuessNumberGame(seniorInfo, 5);
        while (seniorInfo.getCurrentGame() != null) {
            senior.guessNumber(seniorInfo, new Random().nextInt(5));
        }
        System.out.println();

        System.out.println("after");
        PlayerCommonBehavior playerCommonBehavior = new PlayerCommonBehavior(guessNumberGame);
        Player templateGuest = new TemplateGuest(playerCommonBehavior);
        Player templateRookiePlayer = new TemplateRookiePlayer(playerCommonBehavior);
        Player templateSeniorPlayer = new TemplateSeniorPlayer(playerCommonBehavior);

        PlayerInfo templateGuestInfo = templateGuest.buildPlayer("遊客");
        templateGuest.playGuessNumberGame(templateGuestInfo, 5);
        while (templateGuestInfo.getCurrentGame() != null) {
            templateGuest.guessNumber(templateGuestInfo, new Random().nextInt(5));
        }
        System.out.println();

        PlayerInfo templateRookieInfo = templateRookiePlayer.buildPlayer("初級玩家");
        templateRookiePlayer.playGuessNumberGame(templateRookieInfo, 5);
        while (templateRookieInfo.getCurrentGame() != null) {
            templateRookiePlayer.guessNumber(templateRookieInfo, new Random().nextInt(5));
        }
        System.out.println();

        PlayerInfo templateSeniorInfo = templateSeniorPlayer.buildPlayer("高級玩家");
        templateSeniorPlayer.playGuessNumberGame(templateSeniorInfo, 5);
        while (templateSeniorInfo.getCurrentGame() != null) {
            templateSeniorPlayer.guessNumber(templateSeniorInfo, new Random().nextInt(5));
        }
        System.out.println();
    }
}
