package org.example.BehavioralPatterns.Command;

import org.example.BehavioralPatterns.Command.after.CommandFactory;
import org.example.BehavioralPatterns.Command.after.Customer;
import org.example.BehavioralPatterns.Command.after.ShoppingMall;
import org.example.BehavioralPatterns.Command.after.Website;
import org.example.BehavioralPatterns.Command.object.CustomerData;
import org.example.BehavioralPatterns.Command.object.ItemData;

public class Main {
    public static void main(String[] args) {
        ShoppingMall shoppingMall = new ShoppingMall();
        CommandFactory commandFactory = new CommandFactory(shoppingMall);
        Website website = new Website();
        Customer customer = new Customer(commandFactory, website);

        CustomerData customer1 = new CustomerData(1);
        ItemData bread = new ItemData("麵包", 5);
        ItemData beer = new ItemData("啤酒", 20);
        ItemData water = new ItemData("水", 10);
        customer.addItem(customer1,bread);
        customer.addItem(customer1,beer);
        customer.addItem(customer1,water);
        customer.removeItem(customer1,water);
        customer.checkout(customer1);

        CustomerData customer2 = new CustomerData(2);
        customer.addItem(customer2,bread);
        customer.addItem(customer2,beer);
        customer.addItem(customer2,water);
        customer.removeItem(customer2,beer);
        customer.checkout(customer2);
    }
}