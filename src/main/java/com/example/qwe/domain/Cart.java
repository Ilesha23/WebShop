package com.example.qwe.domain;

import java.util.LinkedList;
import java.util.List;

public class Cart {
    private List<Item> items = new LinkedList<>();

    public void add(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return new LinkedList<>(items);
    }

    public int getSize() {
        return items.size();
    }

    public void remove(int index) {
        items.remove(index);
    }

    public double getPrice() {
        double price = 0.0;
        for (Item item: items) {
            price += item.getPrice();
        }
        return price;
    }
}
