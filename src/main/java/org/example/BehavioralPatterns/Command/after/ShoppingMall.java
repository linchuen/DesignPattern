package org.example.BehavioralPatterns.Command.after;

import org.example.BehavioralPatterns.Command.object.CustomerData;
import org.example.BehavioralPatterns.Command.object.ItemData;
import org.example.BehavioralPatterns.Command.object.Receiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ShoppingMall implements Receiver {
    private final Map<CustomerData, List<ItemData>> customerShoppingCart = new HashMap<>();

    public void addItemToShoppingCart(CustomerData customerData, ItemData itemData) {
        List<ItemData> itemDataList = customerShoppingCart.getOrDefault(customerData, new ArrayList<>());
        itemDataList.add(itemData);
        customerShoppingCart.put(customerData, itemDataList);

        System.out.println("用戶:" + customerData.getId() + " 新增" + itemData.getName() + "至購物車");
    }

    public void removeItemFromShoppingCart(CustomerData customerData, ItemData itemData) {
        List<ItemData> itemDataList = customerShoppingCart.get(customerData);
        if (itemDataList == null) throw new NoSuchElementException();
        if (!itemDataList.remove(itemData)) throw new NoSuchElementException();

        customerShoppingCart.put(customerData, itemDataList);

        System.out.println("用戶:" + customerData.getId() + " 移除" + itemData.getName() + "至購物車");
    }

    public void settleOrders(CustomerData customerData) {
        List<ItemData> itemDataList = customerShoppingCart.get(customerData);
        int totalPrice = itemDataList.stream().map(ItemData::getPrice).reduce(0, Integer::sum);
        System.out.println("共" + itemDataList.size() + "個物品，總金額:" + totalPrice + "\n");
        customerShoppingCart.remove(customerData);
    }
}
