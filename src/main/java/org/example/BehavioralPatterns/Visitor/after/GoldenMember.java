package org.example.BehavioralPatterns.Visitor.after;

import org.example.BehavioralPatterns.Visitor.object.Book;
import org.example.BehavioralPatterns.Visitor.object.MemberData;
import org.example.BehavioralPatterns.Visitor.object.MemberType;

public class GoldenMember implements Member {
    @Override
    public void buy(MemberData memberData, BookStore bookStore, Book book) {
        bookStore.addBookToShoppingCart(memberData, book);
    }

    @Override
    public MemberData buildMembershipCard(String name) {
        return new MemberData(name, MemberType.Golden);
    }

    @Override
    public double visit(SkyBookStore skyBookStore) {
        double discount = skyBookStore.getDiscount(MemberType.Golden);
        System.out.println("黃金會員 在 sky書局打" + (int) (discount * 10) + "折");
        return discount;
    }

    @Override
    public double visit(DragonBookStore dragonBookStore) {
        double discount = dragonBookStore.getDiscount(MemberType.Golden);
        System.out.println("黃金會員 在 dragon書局打" + (int) (discount * 10) + "折");
        return discount;
    }
}
