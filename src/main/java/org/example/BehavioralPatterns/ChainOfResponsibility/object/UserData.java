package org.example.BehavioralPatterns.ChainOfResponsibility.object;

import java.time.LocalDateTime;

public class UserData {
    private final int age;
    private final int level;
    private final LocalDateTime birthday;
    private final BloodType bloodType;

    public UserData(int age, int level, LocalDateTime birthday, BloodType bloodType) {
        this.age = age;
        this.level = level;
        this.birthday = birthday;
        this.bloodType = bloodType;
    }

    public int getAge() {
        return age;
    }

    public int getLevel() {
        return level;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
