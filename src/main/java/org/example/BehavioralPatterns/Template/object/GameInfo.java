package org.example.BehavioralPatterns.Template.object;

import java.util.HashSet;
import java.util.Set;

public class GameInfo {
    private int number;
    private final int range;

    private final Set<Integer> guessedNumber = new HashSet<>();

    public GameInfo(int range) {
        this.range = range;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getRange() {
        return range;
    }

    public void addGuessedNumber(int number){
        guessedNumber.add(number);
    };

    public Set<Integer> getGuessedNumber() {
        return guessedNumber;
    }
}
