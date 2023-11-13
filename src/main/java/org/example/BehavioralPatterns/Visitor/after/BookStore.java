package org.example.BehavioralPatterns.Visitor.after;

import org.example.BehavioralPatterns.Visitor.object.Book;
import org.example.BehavioralPatterns.Visitor.object.MemberData;
import org.example.BehavioralPatterns.Visitor.object.MemberType;

public interface BookStore {
    void addBookToShoppingCart(MemberData member, Book book);

    double getSettlePrice(MemberData member);

    double getDiscount(MemberType memberType);

    double accept(Member member);
}
