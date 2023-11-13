package org.example.BehavioralPatterns.Visitor.after;

import org.example.BehavioralPatterns.Visitor.object.Book;
import org.example.BehavioralPatterns.Visitor.object.MemberData;

public interface Member {
    void buy(MemberData memberData, BookStore bookStore, Book book);

    MemberData buildMembershipCard(String name);

    double visit(SkyBookStore skyBookStore);

    double visit(DragonBookStore dragonBookStore);
}
