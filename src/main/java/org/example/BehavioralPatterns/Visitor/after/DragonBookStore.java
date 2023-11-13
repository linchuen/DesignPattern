package org.example.BehavioralPatterns.Visitor.after;

import org.example.BehavioralPatterns.Visitor.object.Book;
import org.example.BehavioralPatterns.Visitor.object.MemberData;
import org.example.BehavioralPatterns.Visitor.object.MemberType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DragonBookStore implements BookStore {
    private final Map<String, List<Book>> memberShoppingCart = new HashMap<>();

    @Override
    public void addBookToShoppingCart(MemberData memberData, Book book) {
        List<Book> bookShoppingCart = memberShoppingCart.getOrDefault(memberData.getName(), new ArrayList<>());
        bookShoppingCart.add(book);
        memberShoppingCart.put(memberData.getName(), bookShoppingCart);
    }

    @Override
    public double getSettlePrice(MemberData memberData) {
        List<Book> bookShoppingCart = memberShoppingCart.get(memberData.getName());
        if (bookShoppingCart == null || bookShoppingCart.isEmpty()) return 0;

        String bookNames = bookShoppingCart.stream().map(Book::getName).collect(Collectors.joining(","));
        System.out.println(memberData.getName() + "購買[" + bookNames + "]");

        int totalPrice = bookShoppingCart.stream()
                .map(Book::getPrice)
                .reduce(0, Integer::sum);
        memberShoppingCart.remove(memberData.getName());
        return getDiscount(memberData.getType()) * totalPrice;
    }

    @Override
    public double getDiscount(MemberType memberType) {
        switch (memberType) {
            case Golden -> {
                return 0.5;
            }
            case Normal -> {
                return 0.8;
            }
            default -> {
                return 1;
            }
        }
    }

    @Override
    public double accept(Member member) {
        return member.visit(this);
    }

}
