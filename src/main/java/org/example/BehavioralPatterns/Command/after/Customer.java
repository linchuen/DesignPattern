package org.example.BehavioralPatterns.Command.after;

import org.example.BehavioralPatterns.Command.object.Client;
import org.example.BehavioralPatterns.Command.object.CustomerData;
import org.example.BehavioralPatterns.Command.object.ItemData;

public class Customer implements Client {
    private final CommandFactory commandFactory;
    private final Website website;

    public Customer(CommandFactory commandFactory, Website website) {
        this.commandFactory = commandFactory;
        this.website = website;
    }

    public void addItem(CustomerData customerData, ItemData itemData) {
        CommandFactory.AddCommand addCommand = commandFactory.getAddCommand(customerData, itemData);
        website.addCommand(customerData, addCommand);
    }

    public void removeItem(CustomerData customerData, ItemData itemData) {
        CommandFactory.RemoveCommand removeCommand = commandFactory.getRemoveCommand(customerData, itemData);
        website.addCommand(customerData, removeCommand);
    }

    public void checkout(CustomerData customerData) {
        CommandFactory.CheckoutCommand checkoutCommand = commandFactory.getCheckoutCommand(customerData);
        website.addCommand(customerData, checkoutCommand);
        website.process(customerData);
    }

    public void cancel(CustomerData customerData){
        website.removeAllCommand(customerData);
    }
}
