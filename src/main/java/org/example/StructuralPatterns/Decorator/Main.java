package org.example.StructuralPatterns.Decorator;

import org.example.StructuralPatterns.Bridge.after.adventurer.Warrior;
import org.example.StructuralPatterns.Bridge.after.object.Adventurer;
import org.example.StructuralPatterns.Bridge.after.spell.AdvancedFireBall;
import org.example.StructuralPatterns.Bridge.after.spell.FireBall;
import org.example.StructuralPatterns.Bridge.after.weapon.Staff;
import org.example.StructuralPatterns.Bridge.after.weapon.Sword;
import org.example.StructuralPatterns.Bridge.before.AdventurerServiceImpl;
import org.example.StructuralPatterns.Bridge.before.object.AdventurerService;
import org.example.StructuralPatterns.Bridge.before.object.AdventurerType;
import org.example.StructuralPatterns.Decorator.after.ClientService;
import org.example.StructuralPatterns.Decorator.object.ClientType;

public class Main {

    public static void main(String[] args) {
        System.out.println("before");
        org.example.StructuralPatterns.Decorator.before.ClientService beforeClient = new org.example.StructuralPatterns.Decorator.before.ClientService();
        beforeClient.sendMessage(ClientType.Apple);
        System.out.println();
        beforeClient.sendMessage(ClientType.Google);
        System.out.println();

        System.out.println("after");
        org.example.StructuralPatterns.Decorator.after.ClientService afterClient = new org.example.StructuralPatterns.Decorator.after.ClientService();
        afterClient.sendMessage(ClientType.Apple);
        System.out.println();
        afterClient.sendMessage(ClientType.Google);
        System.out.println();
    }
}