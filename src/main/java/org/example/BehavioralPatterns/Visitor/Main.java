package org.example.BehavioralPatterns.Visitor;


import org.example.BehavioralPatterns.Visitor.after.DragonBookStore;
import org.example.BehavioralPatterns.Visitor.after.GoldenMember;
import org.example.BehavioralPatterns.Visitor.after.Member;
import org.example.BehavioralPatterns.Visitor.after.NormalMember;
import org.example.BehavioralPatterns.Visitor.after.SkyBookStore;
import org.example.BehavioralPatterns.Visitor.object.Book;
import org.example.BehavioralPatterns.Visitor.object.MemberData;

public class Main {
    public static void main(String[] args) {
        Book cleanCode = new Book("CleanCode", 1000);
        Book goodeCodeBadCode = new Book("GoodeCodeBadCode", 500);

        SkyBookStore skyBookStore = new SkyBookStore();
        DragonBookStore dragonBookStore = new DragonBookStore();

        Member normalMember = new NormalMember();
        Member goldenMember = new GoldenMember();

        MemberData steve = normalMember.buildMembershipCard("Steve");
        MemberData aiden = goldenMember.buildMembershipCard("Aiden");

        normalMember.buy(steve, skyBookStore, cleanCode);
        normalMember.buy(steve, skyBookStore, goodeCodeBadCode);
        normalMember.buy(steve, dragonBookStore, cleanCode);
        normalMember.buy(steve, dragonBookStore, goodeCodeBadCode);

        goldenMember.buy(aiden, skyBookStore, cleanCode);
        goldenMember.buy(aiden, skyBookStore, goodeCodeBadCode);
        goldenMember.buy(aiden, dragonBookStore, cleanCode);
        goldenMember.buy(aiden, dragonBookStore, goodeCodeBadCode);

        System.out.println(steve.getName() + " 在 sky書局 購買金額為" + skyBookStore.getSettlePrice(steve) + "\n");
        System.out.println(steve.getName() + " 在 dragon書局 購買金額為" + dragonBookStore.getSettlePrice(steve) + "\n");

        System.out.println(aiden.getName() + " 在 sky書局 購買金額為" + skyBookStore.getSettlePrice(aiden) + "\n");
        System.out.println(aiden.getName() + " 在 dragon書局 購買金額為" + dragonBookStore.getSettlePrice(aiden) + "\n");

        normalMember.visit(skyBookStore);
        normalMember.visit(dragonBookStore);
        goldenMember.visit(skyBookStore);
        goldenMember.visit(dragonBookStore);
    }

}
