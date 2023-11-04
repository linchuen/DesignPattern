package org.example.StructuralPatterns.Bridge;

import org.example.CreationalPatterns.Factory.after.FactoryLetterFactory;
import org.example.CreationalPatterns.Factory.object.LanguageType;
import org.example.CreationalPatterns.Factory.object.Letter;
import org.example.CreationalPatterns.Factory.object.LetterFactory;
import org.example.StructuralPatterns.Bridge.after.adventurer.Warrior;
import org.example.StructuralPatterns.Bridge.after.object.Adventurer;
import org.example.StructuralPatterns.Bridge.after.spell.AdvancedFireBall;
import org.example.StructuralPatterns.Bridge.after.spell.FireBall;
import org.example.StructuralPatterns.Bridge.after.weapon.Staff;
import org.example.StructuralPatterns.Bridge.after.weapon.Sword;
import org.example.StructuralPatterns.Bridge.before.AdventurerServiceImpl;
import org.example.StructuralPatterns.Bridge.before.object.AdventurerService;
import org.example.StructuralPatterns.Bridge.before.object.AdventurerType;

public class Main {

    public static void main(String[] args) {
        System.out.println("before");
        AdventurerService adventurerService = new AdventurerServiceImpl();
        System.out.print("戰士: ");
        adventurerService.attack(AdventurerType.Warrior);
        System.out.print("見習魔法師: ");
        adventurerService.attack(AdventurerType.TraineeMagician);
        System.out.print("大法師: ");
        adventurerService.attack(AdventurerType.SuperMagician);
        System.out.println();

        System.out.print("戰士: ");
        adventurerService.castSpell(AdventurerType.Warrior);
        System.out.print("見習魔法師: ");
        adventurerService.castSpell(AdventurerType.TraineeMagician);
        System.out.print("大法師: ");
        adventurerService.castSpell(AdventurerType.SuperMagician);
        System.out.println();

        System.out.println("after");
        Adventurer warrior = new Warrior(new Sword(), new FireBall());
        Adventurer traineeMagician = new Warrior(new Staff(), new FireBall());
        Adventurer superMagician = new Warrior(new Staff(), new AdvancedFireBall());
        System.out.print("戰士: ");
        warrior.attack();
        System.out.print("見習魔法師: ");
        traineeMagician.attack();
        System.out.print("大法師: ");
        superMagician.attack();
        System.out.println();

        System.out.print("戰士: ");
        warrior.castSpell();
        System.out.print("見習魔法師: ");
        traineeMagician.castSpell();
        System.out.print("大法師: ");
        superMagician.castSpell();
        System.out.println();
    }
}