package org.example.BehavioralPatterns.Command.after;

import org.example.BehavioralPatterns.Command.object.Command;
import org.example.BehavioralPatterns.Command.object.CustomerData;
import org.example.BehavioralPatterns.Command.object.ItemData;

public class CommandFactory {
    private final ShoppingMall shoppingMall;

    public CommandFactory(ShoppingMall shoppingMall) {
        this.shoppingMall = shoppingMall;
    }

    public AddCommand getAddCommand(CustomerData customerData, ItemData itemData) {
        return new AddCommand(shoppingMall, customerData, itemData);
    }

    public RemoveCommand getRemoveCommand(CustomerData customerData, ItemData itemData) {
        return new RemoveCommand(shoppingMall, customerData, itemData);
    }

    public CheckoutCommand getCheckoutCommand(CustomerData customerData) {
        return new CheckoutCommand(shoppingMall, customerData);
    }

    public static class AddCommand implements Command {
        private final ShoppingMall shoppingMall;
        private final CustomerData customerData;
        private final ItemData itemData;

        public AddCommand(ShoppingMall shoppingMall, CustomerData customerData, ItemData itemData) {
            this.shoppingMall = shoppingMall;
            this.customerData = customerData;
            this.itemData = itemData;
        }

        @Override
        public void execute() {
            shoppingMall.addItemToShoppingCart(customerData, itemData);
        }
    }

    public static class RemoveCommand implements Command {
        private final ShoppingMall shoppingMall;
        private final CustomerData customerData;
        private final ItemData itemData;

        public RemoveCommand(ShoppingMall shoppingMall, CustomerData customerData, ItemData itemData) {
            this.shoppingMall = shoppingMall;
            this.customerData = customerData;
            this.itemData = itemData;
        }

        @Override
        public void execute() {
            shoppingMall.removeItemFromShoppingCart(customerData, itemData);
        }
    }

    public static class CheckoutCommand implements Command {
        private final ShoppingMall shoppingMall;
        private final CustomerData customerData;

        public CheckoutCommand(ShoppingMall shoppingMall, CustomerData customerData) {
            this.shoppingMall = shoppingMall;
            this.customerData = customerData;
        }

        @Override
        public void execute() {
            shoppingMall.settleOrders(customerData);
        }
    }
}

